package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.CardDataSource
import ir.siriusapps.domain.entity.Card
import javax.inject.Inject

class RemoveCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun removeCard(card: Card) = cardDataSource.remove(card)

    suspend fun removeCard(cards: List<Card>) = cardDataSource.remove(cards)

}