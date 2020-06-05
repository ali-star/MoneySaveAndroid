package com.example.core.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import jdk.nashorn.internal.objects.annotations.Property
import java.util.*

@Entity(tableName = "Bank")
open  class Bank(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)
    var id: Long=0,
    val uuid:String,
    val name: String,
    val persianName: String,
    val bankAccountId: Long
)