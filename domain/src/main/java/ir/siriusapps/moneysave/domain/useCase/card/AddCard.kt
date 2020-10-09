package ir.siriusapps.moneysave.domain.useCase.card

import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.model.Card
import javax.inject.Inject

class AddCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun addCard(card: Card) = cardRepository.add(card)

    suspend fun addCard(cards: List<Card>) = cardRepository.add(cards)
}