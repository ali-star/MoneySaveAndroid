package ir.siriusapps.moneysave.data.repository.source.remote

import com.google.gson.Gson
import ir.siriusapps.moneysave.data.remote.internal.TokenEntity
import ir.siriusapps.moneysave.data.remote.models.LoginModel
import ir.siriusapps.moneysave.data.repository.source.remote.internal.Authenticator
import ir.siriusapps.moneysave.data.repository.source.remote.internal.NetworkService
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test

class NetworkServiceTest {

    private var server = MockWebServer()
    private lateinit var networkService: NetworkService

    @Before
    fun setup() {
        server.start()

        val baseUrl = server.url("test/")

        val gson = Gson()

        val authenticator = Authenticator(
            NetworkService.MAIN_DOMAIN,
            getToken = {
                return@Authenticator TokenEntity("fake_token", "fake_refresh_token")
            },
            onTokenUpdated = {

            },
            onUnauthorized = {

            },
            gson
        )
        authenticator.initRetrofit(baseUrl)

        networkService = NetworkService(NetworkService.MAIN_DOMAIN, gson, authenticator, getUser = {
            return@NetworkService null
        })

        networkService.initRetrofit(baseUrl)
    }

    @Test
    fun `test login api`() {
        server.enqueue(MockResponse().setBody("""
            {
                "id": "e9869264-247a-46b1-a95f-1e5298290fa4",
                "created_at": "2020-09-18T12:46:05.123044Z",
                "update_at": "2020-10-11T22:02:54.489465702Z",
                "deleted_at": null,
                "userName": "ali-star",
                "firstName": "ali",
                "lastName": "mohseni",
                "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDI0NTQ2NzQsImlhdCI6MTYwMjQ1Mzc3NCwidXNlcklkIjoiZTk4NjkyNjQtMjQ3YS00NmIxLWE5NWYtMWU1Mjk4MjkwZmE0In0.W8WdZxR7RRTOXzsj6c_s7LldfIAiJQTC0k5HcR2Gew8",
                "refreshToken": "3SgX9pv80ClL-FVDQ-8uZw0S7nFlNSj4AWMM9cj9BXZR_3uvtxT0jrqV2yFHkYGLLrzRl48ARDJTCMRXR-_s7sn6A4mcyck-"
            }
        """.trimIndent()))

        val user = runBlocking {
            networkService.getApis().login(LoginModel("ali-star", "0000"))
        }

        assertTrue(user.userName == "ali-star")
    }

    @Test
    fun `test refreshToken api`() {
        server.enqueue(MockResponse().setBody("""
            {
                "refreshToken": "jzVb0IlTBUPXK5-J8L-NOPus5ScQJcXYGf5rMMBFzNcscfEUG5Wy3jnqn1VGaDs1RcOcqcQKYiiv5otSQwGeQ-IgrkEEoxzi"
            }
        """.trimIndent()))

        val tokenEntity = runBlocking {
            networkService.getApis().refreshToken(TokenEntity("token", "refresh_token"))
        }

        assertTrue(tokenEntity.refreshToken == "jzVb0IlTBUPXK5-J8L-NOPus5ScQJcXYGf5rMMBFzNcscfEUG5Wy3jnqn1VGaDs1RcOcqcQKYiiv5otSQwGeQ-IgrkEEoxzi")
    }

}