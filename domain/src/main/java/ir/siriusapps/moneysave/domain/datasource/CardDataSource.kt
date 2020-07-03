package ir.siriusapps.moneysave.domain.datasource

import ir.siriusapps.moneysave.domain.entity.Card

interface CardDataSource {

    suspend fun add(card: Card)

    suspend fun add(cards: List<Card>)

    suspend fun remove(card: Card)

    suspend fun remove(cards: List<Card>)

    suspend fun read():List<Card>
}