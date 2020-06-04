package com.example.core.iteractors

import com.example.core.data.repository.CardRepo
import com.example.core.domain.entity.Card

class AddCard(private val cardRepo: CardRepo) {
    suspend fun addCard(card: Card) = cardRepo.addCard(card)
}