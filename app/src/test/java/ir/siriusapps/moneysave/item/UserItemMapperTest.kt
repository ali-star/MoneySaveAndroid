package ir.siriusapps.moneysave.item

import ir.siriusapps.moneysave.domain.entity.User
import org.junit.Test

class UserItemMapperTest {

    private val testUser = User(
        "1",
        "userName",
        "firstName",
        "lastName",
        "token",
        "refreshToken"
    )

    private val testUserItem = UserItem(
        "1",
        "userName",
        "fistName",
        "lastName",
        "token",
        "refreshToken"
    )

    @Test
    fun mapToDomainTest() {
        val userItemMapper = UserItemMapper()
        val user = userItemMapper.mapToDomain(testUserItem)
        assert(user.id == testUserItem.id)
        assert(user.userName == testUserItem.userName)
        assert(user.firstName == testUserItem.firstName)
        assert(user.lastName == testUserItem.lastName)
        assert(user.token == testUserItem.token)
        assert(user.refreshToken == testUserItem.refreshToken)
    }

    @Test
    fun mapToPresentationTest() {
        val userItemMapper = UserItemMapper()
        val userItem = userItemMapper.mapToPresentation(testUser)
        assert(userItem.id == testUser.id)
        assert(userItem.userName == testUser.userName)
        assert(userItem.firstName == testUser.firstName)
        assert(userItem.lastName == testUser.lastName)
        assert(userItem.token == testUser.token)
        assert(userItem.refreshToken == testUser.refreshToken)
    }

}