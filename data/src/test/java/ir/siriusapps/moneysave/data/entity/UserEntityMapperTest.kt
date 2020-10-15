package ir.siriusapps.moneysave.data.entity

import ir.siriusapps.moneysave.domain.entity.User
import org.junit.Test

class UserEntityMapperTest {

    private val testUser = User(
        "1",
        "userName",
        "firstName",
        "lastName",
        "token",
        "refreshToken"
    )

    private val testUserEntity = UserEntity(
        "1",
        "userName",
        "firstName",
        "lastName",
        "tokenString",
        "refreshToken")

    @Test
    fun mapToDomainTest() {
        val userEntityMapper = UserEntityMapper()
        val user = userEntityMapper.mapToDomain(testUserEntity)
        assert(user.id == testUserEntity.id)
        assert(user.userName == testUserEntity.userName)
        assert(user.firstName == testUserEntity.firstName)
        assert(user.lastName == testUserEntity.lastName)
        assert(user.token == testUserEntity.tokenString)
        assert(user.refreshToken == testUserEntity.refreshToken)
    }

    @Test
    fun mapToDataTest() {
        val userEntityMapper = UserEntityMapper()
        val userEntity = userEntityMapper.mapToData(testUser)
        assert(userEntity.id == testUser.id)
        assert(userEntity.userName == testUser.userName)
        assert(userEntity.firstName == testUser.firstName)
        assert(userEntity.lastName == testUser.lastName)
        assert(userEntity.tokenString == testUser.token)
        assert(userEntity.refreshToken == testUser.refreshToken)
    }

}