package ir.siriusapps.moneysave.data.entity.mapper

import ir.siriusapps.moneysave.data.entity.EntityModel
import ir.siriusapps.moneysave.domain.entity.Model

interface Mapper<M : Model, EM : EntityModel> {

    fun mapToDomain(entityModel: EM): M
    fun mapToData(model: M): EM

}