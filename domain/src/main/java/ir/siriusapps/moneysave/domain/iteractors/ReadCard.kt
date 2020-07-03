package ir.siriusapps.moneysave.domain.iteractors

import ir.siriusapps.moneysave.domain.datasource.CardDataSource
import ir.siriusapps.moneysave.domain.entity.Card
import javax.inject.Inject

class ReadCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun readCard():List<Card> = cardDataSource.read()

}