package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.CardDataSource
import ir.irsiusapps.domain.entity.Card
import javax.inject.Inject

class AddCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun addCard(card: Card) = cardDataSource.add(card)

    suspend fun addCard(cards: List<Card>) = cardDataSource.add(cards)
}