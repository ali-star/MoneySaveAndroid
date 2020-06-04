package com.example.core.domain.entity

import androidx.room.Entity

@Entity(tableName = "User")
data class User(val localId: Long, val id: String, val name: String)
