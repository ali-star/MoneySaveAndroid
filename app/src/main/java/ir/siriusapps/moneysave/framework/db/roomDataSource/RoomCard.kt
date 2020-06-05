package ir.siriusapps.moneysave.framework.db.roomDataSource

import com.example.core.data.datasource.CardDataSource
import com.example.core.domain.entity.Card
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard
import javax.inject.Inject

open class RoomCard @Inject constructor(private val daoCard: RoomDaoCard) : CardDataSource {
    private lateinit var list: ArrayList<Card>
    override fun add(card: Card) {
        list = ArrayList<Card>()
        list.add(card)
        daoCard.insertCards(list)
    }

    override fun add(cards: List<Card>) {
        daoCard.insertCards(cards)
    }

    override fun remove(card: Card) {
        list = ArrayList<Card>()
        list.add(card)
        daoCard.deleteCards(list)
    }

    override fun remove(cards: List<Card>) {
        daoCard.deleteCards(cards)
    }

    override fun read(): List<Card> {
        return daoCard.getCards()
    }

}