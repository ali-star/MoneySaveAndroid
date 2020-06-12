package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.entity.Card


class AddCard(private val cardRepo: CardRepo) {

    suspend fun addCard(card: Card) = cardRepo.addCard(card)

    suspend fun addCard(cards: List<Card>) = cardRepo.addCard(cards)
}