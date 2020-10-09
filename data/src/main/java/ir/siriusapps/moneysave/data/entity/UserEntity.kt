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

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long,

    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
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
        modelEntity.localId,
        modelEntity.id,
        modelEntity.name
    )


    override fun mapToData(model: User): UserEntity = UserEntity(
        model.localId,
        model.id,
        model.name
    )
}
