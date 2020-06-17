package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.datasource.CardDataSource
import ir.irsiusapps.domain.entity.Card
import javax.inject.Inject

class ReadCard @Inject constructor(private val cardDataSource: CardDataSource) {

    suspend fun readCard():List<Card> = cardDataSource.read()

}