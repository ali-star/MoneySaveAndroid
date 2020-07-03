package ir.siriusapps.moneysave.data.repository

import ir.siriusapps.moneysave.domain.datasource.CardDataSource
import ir.siriusapps.moneysave.domain.entity.Card

class CardRepo(private val cardDataSource: CardDataSource) {

    suspend fun addCard(card: Card) = cardDataSource.add(card)

    suspend fun removeCard(card: Card) = cardDataSource.remove(card)

    suspend fun readCard(): List<Card> = cardDataSource.read()

    suspend fun addCard(cards: List<Card>) = cardDataSource.add(cards)

    suspend fun removeCard(cards: List<Card>) = cardDataSource.remove(cards)

}