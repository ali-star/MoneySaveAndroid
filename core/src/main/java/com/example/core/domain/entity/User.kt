package com.example.core.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "User")
data class User(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    val localId: Long,
    val uuid: String,
    val name: String
)
