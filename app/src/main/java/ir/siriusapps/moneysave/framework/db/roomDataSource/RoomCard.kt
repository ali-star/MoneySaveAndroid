package ir.siriusapps.moneysave.framework.db.roomDataSource

import android.content.Context
import com.example.core.data.datasource.CardDataSource
import com.example.core.domain.entity.Bank
import com.example.core.domain.entity.Card
import ir.siriusapps.moneysave.framework.db.mainDb.roomDao.RoomDaoCard
import javax.inject.Inject

class RoomCard @Inject constructor(private val daoCard: RoomDaoCard) : CardDataSource {
    private lateinit var list: ArrayList<Card>
    override fun add(card: Card) {
        list = ArrayList<Card>()
        list.add(card)
        daoCard.insertCard(list)
    }

    override fun add(cards: List<Card>) {
        daoCard.insertCard(cards)
    }

    override fun remove(card: Card) {
        list = ArrayList<Card>()
        list.add(card)
        daoCard.deleteCard(list)
    }

    override fun remove(cards: List<Card>) {
        daoCard.deleteCard(cards)
    }

    override fun read(): List<Card> {
        return daoCard.selectCard()
    }

}