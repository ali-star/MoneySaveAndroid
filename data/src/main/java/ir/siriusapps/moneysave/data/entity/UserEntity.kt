package ir.siriusapps.moneysave.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.data.entity.mapper.Mapper
import javax.inject.Inject

@Entity(tableName = "User")
open class UserEntity(

    @ColumnInfo(name = "localId") @PrimaryKey(autoGenerate = true)
    val localId: Long,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String

) : EntityModel()

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
