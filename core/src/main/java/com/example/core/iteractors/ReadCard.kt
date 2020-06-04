package com.example.core.iteractors

import com.example.core.data.repository.CardRepo
import com.example.core.domain.entity.Card

class ReadCard(private val cardRepo: CardRepo) {
    suspend fun readCard(card: Card) = cardRepo.readCard(card)
}