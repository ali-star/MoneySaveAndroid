package ir.siriusapps.moneysave.domain.iteractors

import ir.siriusapps.moneysave.domain.datasource.CardRepository
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

class RemoveCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun removeCard(card: Card) = cardRepository.remove(card)

    suspend fun removeCard(cards: List<Card>) = cardRepository.remove(cards)

}