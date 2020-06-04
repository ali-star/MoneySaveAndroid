package com.example.core.data.datasource

import com.example.core.domain.entity.Card

interface CardDataSource {
    fun add(card: Card)
    fun remove(card: Card)
    fun read(card: Card)
}