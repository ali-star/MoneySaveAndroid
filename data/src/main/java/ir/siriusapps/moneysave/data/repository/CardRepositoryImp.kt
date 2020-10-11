package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.data.repository.source.local.Dao
import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.entity.Card
import ir.siriusapps.moneysave.data.entity.CardEntityMapper
import ir.siriusapps.moneysave.domain.scope.ApplicationScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ApplicationScope
class CardRepositoryImp @Inject constructor(
    private val moneySaveDao: Dao,
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


