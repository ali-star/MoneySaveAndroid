package ir.siriusapps.moneysave.data.remote.entity

import com.auth0.android.jwt.JWT
import com.google.gson.annotations.SerializedName
import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.data.local.entity.mapper.Mapper
import ir.siriusapps.moneysave.domain.entity.User
import javax.inject.Inject

open class UserEntity(

    val id: String,

    val name: String,

    @SerializedName("token")
    var tokenString: String? = null,

    @SerializedName("refreshToken")
    var refreshToken: String? = null

) : EntityModel() {

    val token: JWT? get() = if (tokenString == null) null else JWT(tokenString!!)

}

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
