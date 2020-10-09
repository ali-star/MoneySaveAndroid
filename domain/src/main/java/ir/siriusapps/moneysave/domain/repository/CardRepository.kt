package ir.siriusapps.moneysave.domain.repository

import ir.siriusapps.moneysave.domain.model.Card

interface  CardRepository {

    suspend fun add(card: Card)

    suspend fun add(cards: List<Card>)

    suspend fun remove(card: Card)

    suspend fun remove(cards: List<Card>)

    suspend fun read():List<Card>
}