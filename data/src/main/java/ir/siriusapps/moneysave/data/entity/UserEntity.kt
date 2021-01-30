package ir.siriusapps.moneysave.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject

@Entity(tableName = "User")
open class UserEntity(

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id: String,

    @SerializedName("userName")
    @ColumnInfo(name = "userName")
    var userName: String,

    @SerializedName("firstName")
    @ColumnInfo(name = "firstName")
    var firstName: String,

    @SerializedName("lastName")
    @ColumnInfo(name = "lastName")
    var lastName: String,

    @Ignore
    @SerializedName("token")
    var tokenString: String? = null,

    @Ignore
    @SerializedName("refreshToken")
    var refreshToken: String? = null

) : EntityModel() {

    constructor(): this("", "", "", "", null, null)

}

class UserEntityMapper @Inject constructor() : Mapper<User, UserEntity> {
    override fun mapToDomain(entityModel: UserEntity): User = User(
        entityModel.id,
        entityModel.userName,
        entityModel.firstName,
        entityModel.lastName,
    )

    override fun mapToData(model: User): UserEntity = UserEntity(
        model.id,
        model.userName,
        model.firstName,
        model.lastName,
    )
}
