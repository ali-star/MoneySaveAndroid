package ir.siriusapps.moneysave.data.local.entity.mapper

import ir.siriusapps.moneysave.data.local.entity.EntityModel
import ir.siriusapps.moneysave.domain.entity.Model

interface Mapper<M : Model, EM : EntityModel> {

    fun mapToDomain(modelEntity: EM): M
    fun mapToData(model: M): EM

}