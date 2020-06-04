package com.example.core.data.datasource

import com.example.core.domain.entity.User

interface UserDataSource {
    fun add(user: User)
    fun remove(user: User)
    fun read(user: User)
}