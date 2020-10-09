package ir.siriusapps.moneysave.domain.useCase.card

import ir.siriusapps.moneysave.domain.repository.CardRepository
import ir.siriusapps.moneysave.domain.model.Card
import javax.inject.Inject

class ReadCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun readCard():List<Card> = cardRepository.read()

}