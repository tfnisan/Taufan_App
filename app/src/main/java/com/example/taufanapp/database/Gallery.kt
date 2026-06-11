package com.example.taufanapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gallery")
data class Gallery(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val imageResId: Int,
    val description: String
)
