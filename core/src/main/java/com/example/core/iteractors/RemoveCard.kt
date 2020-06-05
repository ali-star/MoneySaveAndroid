package com.example.core.iteractors

import com.example.core.data.repository.CardRepo
import com.example.core.domain.entity.Card

class RemoveCard(private val cardRepo: CardRepo) {

    suspend fun removeCard(card: Card) = cardRepo.removeCard(card)

    suspend fun removeCard(cards: List<Card>) = cardRepo.removeCard(cards)
}