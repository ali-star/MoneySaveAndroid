package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.datasource.CardRepository
import ir.siriusapps.moneysave.domain.entity.Card
import ir.siriusapps.moneysave.domain.entity.CardEntityMapper

class CardRepositoryImp(
    private val moneySaveDao: MoneySaveDao,
    private val cardEntityMapper: CardEntityMapper
) : CardRepository {
    override suspend fun add(card: Card) {
        cardEntityMapper.mapToData(card)
    }

    override suspend fun add(cards: List<Card>) {
        val cardEntity = cards.map {
            cardEntityMapper.mapToData(it)
        }
        moneySaveDao.insertCards(cardEntity)
    }

    override suspend fun remove(card: Card) {
        moneySaveDao.deleteCard(cardEntityMapper.mapToData(card))
    }

    override suspend fun remove(cards: List<Card>) {
        val cardEntities = cards.map {
            cardEntityMapper.mapToData(it)
        }
        moneySaveDao.deleteCards(cardEntities)
    }

    override suspend fun read(): List<Card> {
        val cards = moneySaveDao.getCards().map {
            cardEntityMapper.mapToDomain(it)
        }
        return cards
    }
}


