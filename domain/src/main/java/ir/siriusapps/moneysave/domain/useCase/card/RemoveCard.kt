package ir.siriusapps.moneysave.domain.useCase.card

import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.model.Card
import javax.inject.Inject

class RemoveCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun removeCard(card: Card) = cardRepository.remove(card)

    suspend fun removeCard(cards: List<Card>) = cardRepository.remove(cards)

}