package ir.siriusapps.moneysave.data.local.db

import androidx.room.*
import ir.siriusapps.moneysave.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): UserEntity?

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

}