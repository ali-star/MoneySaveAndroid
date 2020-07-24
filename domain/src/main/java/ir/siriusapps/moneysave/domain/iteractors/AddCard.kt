package ir.siriusapps.moneysave.domain.iteractors

import ir.siriusapps.moneysave.domain.datasource.CardRepository
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

class AddCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun addCard(card: Card) = cardRepository.add(card)

    suspend fun addCard(cards: List<Card>) = cardRepository.add(cards)
}