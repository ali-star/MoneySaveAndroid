package ir.irsiusapps.domain.iteractors

import ir.irsiusapps.domain.entity.Card


class RemoveCard(private val cardRepo: CardRepo) {

    suspend fun removeCard(card: Card) = cardRepo.removeCard(card)

    suspend fun removeCard(cards: List<Card>) = cardRepo.removeCard(cards)
}