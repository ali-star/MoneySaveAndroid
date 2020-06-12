package ir.irsiusapps.data.repository

import ir.irsiusapps.data.datasource.CardDataSource
import ir.irsiusapps.domain.entity.Card


class CardRepo(private val cardDataSource: CardDataSource) {

    suspend fun addCard(card: Card) = cardDataSource.add(card)

    suspend fun removeCard(card: Card) = cardDataSource.remove(card)

    suspend fun readCard(): List<Card> = cardDataSource.read()

    suspend fun addCard(cards: List<Card>) = cardDataSource.add(cards)

    suspend fun removeCard(cards: List<Card>) = cardDataSource.remove(cards)

}