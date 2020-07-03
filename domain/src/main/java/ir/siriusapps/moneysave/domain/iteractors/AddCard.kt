package ir.siriusapps.moneysave.domain.iteractors

import ir.siriusapps.moneysave.domain.datasource.CardDataSource
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

class AddCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun addCard(card: Card) = cardDataSource.add(card)

    suspend fun addCard(cards: List<Card>) = cardDataSource.add(cards)
}