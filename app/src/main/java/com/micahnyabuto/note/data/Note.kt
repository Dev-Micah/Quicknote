package com.micahnyabuto.note.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int=0,
    val content: String,
    val timeCreatedAt: Int
)
