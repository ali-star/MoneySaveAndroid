package com.example.core.domain.entity

import androidx.room.Entity
import java.util.*
@Entity(tableName = "Card")
data class Card(val id: Long, val uuid: UUID, val bankAccountId: Long,val userId:Long)