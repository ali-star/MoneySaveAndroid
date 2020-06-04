package com.example.core.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Card")
data class Card(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    val id: Long
    , val uuid: String
    , val bankAccountId: Long
)