package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.MoneySaveDao
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.model.Card
import ir.siriusapps.moneysave.domain.model.CardEntityMapper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImp @Inject constructor(
    private val moneySaveDao: MoneySaveDao,
    private val cardEntityMapper: CardEntityMapper
) : CardRepository {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun add(card: Card) = withContext(ioDispatcher) {
        moneySaveDao.insertCard(cardEntityMapper.mapToData(card))
    }

    override suspend fun add(cards: List<Card>) = withContext(ioDispatcher) {
        val cardEntity = cards.map {
            cardEntityMapper.mapToData(it)
        }
        moneySaveDao.insertCards(cardEntity)
    }

    override suspend fun remove(card: Card) = withContext(ioDispatcher) {
        moneySaveDao.deleteCard(cardEntityMapper.mapToData(card))
    }

    override suspend fun remove(cards: List<Card>) = withContext(ioDispatcher) {
        val cardEntities = cards.map {
            cardEntityMapper.mapToData(it)
        }
        moneySaveDao.deleteCards(cardEntities)
    }

    override suspend fun read(): List<Card> = withContext(ioDispatcher) {
        return@withContext moneySaveDao.getCards().map {
            cardEntityMapper.mapToDomain(it)
        }
    }

}


