package com.example.taufanapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music_favorites")
data class Music(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val artist: String
)
