package ir.siriusapps.domain.iteractors

import ir.siriusapps.domain.datasource.CardDataSource
import ir.siriusapps.domain.entity.Card
import javax.inject.Inject

class ReadCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun readCard():List<Card> = cardDataSource.read()

}