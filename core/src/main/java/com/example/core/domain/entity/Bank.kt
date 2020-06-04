package com.example.core.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import jdk.nashorn.internal.objects.annotations.Property
import java.util.*

@Entity(tableName = "Bank")
data class Bank(
    val id: Long,
    val uuid: UUID,
    val name: String,
    val persianName: String,
    val bankAccountId: Long
)