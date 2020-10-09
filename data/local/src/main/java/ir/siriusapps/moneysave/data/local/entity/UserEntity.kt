package ir.siriusapps.moneysave.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.local.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject

@Entity(tableName = "User")
open class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "token")
    var tokenString: String? = null,

    @ColumnInfo(name = "refreshToken")
    var refreshToken: String? = null

) : EntityModel()

class UserEntityMapper @Inject constructor() : Mapper<User, UserEntity> {
    override fun mapToDomain(modelEntity: UserEntity): User = User(
        modelEntity.id,
        modelEntity.name
    )


    override fun mapToData(model: User): UserEntity = UserEntity(
        model.id,
        model.name
    )
}
