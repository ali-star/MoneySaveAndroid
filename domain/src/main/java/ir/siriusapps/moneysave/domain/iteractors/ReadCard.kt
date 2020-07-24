package ir.siriusapps.moneysave.domain.iteractors

import ir.siriusapps.moneysave.domain.datasource.CardRepository
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

class ReadCard @Inject constructor(private val cardRepository: CardRepository) {

    suspend fun readCard():List<Card> = cardRepository.read()

}