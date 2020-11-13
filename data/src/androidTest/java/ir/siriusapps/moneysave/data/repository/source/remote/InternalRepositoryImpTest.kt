package ir.siriusapps.moneysave.data.repository.source.remote;

import android.Manifest
import android.content.SharedPreferences
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.google.gson.Gson
import ir.siriusapps.moneysave.data.entity.UserEntityMapper
import ir.siriusapps.moneysave.data.repository.InternalRepositoryImp
import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.data.repository.source.local.db.AppDatabase
import ir.siriusapps.moneysave.data.repository.source.remote.internal.NetworkService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InternalRepositoryImpTest {

    @get:Rule
    val grantInternetPermission: GrantPermissionRule = GrantPermissionRule.grant(Manifest.permission.INTERNET)

    private var server = MockWebServer()

    private lateinit var internalRepositoryImp: InternalRepositoryImp
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var apis: Apis
    private lateinit var dao: Dao
    private val userEntityMapper = UserEntityMapper()

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context

        server.start()
        val baseUrl = server.url("/")

        sharedPreferences = context.getSharedPreferences("data", 0)
        dao = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build().moneySaveDao()
        apis = NetworkService(sharedPreferences, NetworkService.MAIN_DOMAIN, Gson()).apply {
            initRetrofit(baseUrl)
        }.getApis()
        internalRepositoryImp = InternalRepositoryImp(sharedPreferences, apis, dao, userEntityMapper)
    }

    @Test
    fun testLogin() = runBlocking {
        login()

        assertNotNull(dao.getUser())

        assertTrue(sharedPreferences.getBoolean(NetworkService.IS_USER_LOGGED_IN_PREFS_KEY, false))
        assertNotNull(sharedPreferences.getString(NetworkService.TOKEN_PREFS_KEY, null))
        assertNotNull(sharedPreferences.getString(NetworkService.REFRESH_TOKEN_PREFS_KEY, null))
    }

    private suspend fun login() {
        server.enqueue(MockResponse().setBody("""
            {
                "id": "fd4ada3f-36da-4991-a3v5-ed3c8e078020",
                "created_at": "2020-09-18T16:50:14.240877Z",
                "update_at": "2020-11-13T14:46:10.232151641Z",
                "deleted_at": null,
                "userName": "john-smith",
                "email": "john.smith@gmail.com",
                "firstName": "John",
                "lastName": "Smith",
                "token": "buJhbGciOiJIUzI1NiIsrR5caI6IkpXBTPJ9.eyJleHAiOjE2MDUyNzk2NzAsImlhdCI6MTYwNTI3ODc3MCwidXNlcklkIjoiZmQ0YWRhM2YtMzZkYS00OTkxLWEzYTgtZWQzYzhlMDc4MDIwIn0.5I9amrrzuKHJPtJOzUvcRNHa4eHLlVrG12psjOsgYOM",
                "refreshToken": "PlZp7MDoI9jOZY-kObp32gYZxjPLdVox5of4Kh8I0oLC5299SjxcKy3YQ9Cbq0GW6SajRYAcdph2WUi6VE-FDuL4bTWNM0Hp"
            }
        """.trimIndent()))

        val user = internalRepositoryImp.login("ali-star", "0000")

        dao.insertUser(userEntityMapper.mapToData(user))
    }

    @Test
    fun testLogout() = runBlocking {
        login()

        internalRepositoryImp.logout(userEntityMapper.mapToDomain(dao.getUser()!!))

        assertTrue(dao.getUser() == null)
        assertFalse(sharedPreferences.getBoolean(NetworkService.IS_USER_LOGGED_IN_PREFS_KEY, false))
        assertNull(sharedPreferences.getString(NetworkService.TOKEN_PREFS_KEY, null))
        assertNull(sharedPreferences.getString(NetworkService.REFRESH_TOKEN_PREFS_KEY, null))
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}
