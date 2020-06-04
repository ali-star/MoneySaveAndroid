package com.example.core.domain.entity

import androidx.room.Entity
import java.util.*

@Entity(tableName = "BankAccount")
data class BankAccount(
    val id: Long, val uuid: UUID, val userId: User, val bankId: Long)
