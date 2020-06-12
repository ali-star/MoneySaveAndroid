package ir.siriusapps.moneysave.framework.db.roomDataSource

import ir.irsiusapps.data.datasource.CardDataSource
import ir.irsiusapps.domain.entity.Card
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard
import javax.inject.Inject

open class RoomCard @Inject constructor(private val daoCard: RoomDaoCard) :
    ir.irsiusapps.data.datasource.CardDataSource {
    private lateinit var list: ArrayList<ir.irsiusapps.domain.entity.Card>
    override fun add(card: ir.irsiusapps.domain.entity.Card) {
        list = ArrayList<ir.irsiusapps.domain.entity.Card>()
        list.add(card)
        daoCard.insertCards(list)
    }

    override fun add(cards: List<ir.irsiusapps.domain.entity.Card>) {
        daoCard.insertCards(cards)
    }

    override fun remove(card: ir.irsiusapps.domain.entity.Card) {
        list = ArrayList<ir.irsiusapps.domain.entity.Card>()
        list.add(card)
        daoCard.deleteCards(list)
    }

    override fun remove(cards: List<ir.irsiusapps.domain.entity.Card>) {
        daoCard.deleteCards(cards)
    }

    override fun read(): List<ir.irsiusapps.domain.entity.Card> {
        return daoCard.getCards()
    }

}