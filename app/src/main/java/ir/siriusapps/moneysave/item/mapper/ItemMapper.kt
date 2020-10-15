package ir.siriusapps.moneysave.data.entity.mapper


import ir.siriusapps.moneysave.domain.entity.Model
import ir.siriusapps.moneysave.item.Item

interface ItemMapper<M : Model, IM : Item> {

    fun mapToDomain(itemModel: IM): M
    fun mapToPresentation(model: M): IM

}