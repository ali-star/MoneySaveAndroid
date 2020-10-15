package ir.siriusapps.moneysave.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.auth0.android.jwt.JWT
import com.google.gson.annotations.SerializedName
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject

@Entity(tableName = "User")
open class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @SerializedName("userName")
    @ColumnInfo(name = "userName")
    val userName: String,

    @SerializedName("firstName")
    @ColumnInfo(name = "firstName")
    val firstName: String,

    @SerializedName("lastName")
    @ColumnInfo(name = "lastName")
    val lastName: String,

    @SerializedName("token")
    @ColumnInfo(name = "token")
    var tokenString: String? = null,

    @SerializedName("refreshToken")
    @ColumnInfo(name = "refreshToken")
    var refreshToken: String? = null

) : EntityModel() {

    val token: JWT? get() = if (tokenString == null) null else JWT(tokenString!!)

}

class UserEntityMapper @Inject constructor() : Mapper<User, UserEntity> {
    override fun mapToDomain(entityModel: UserEntity): User = User(
        entityModel.id,
        entityModel.userName,
        entityModel.firstName,
        entityModel.lastName,
        entityModel.tokenString,
        entityModel.refreshToken
    )


    override fun mapToData(model: User): UserEntity = UserEntity(
        model.id,
        model.userName,
        model.firstName,
        model.lastName,
        model.token,
        model.refreshToken
    )
}
