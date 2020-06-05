package com.example.core.data.datasource

import com.example.core.domain.entity.Card

interface CardDataSource {

    fun add(card: Card)

    fun add(cards: List<Card>)

    fun remove(card: Card)

    fun remove(cards: List<Card>)

    fun read():List<Card>
}