package com.example.taufanapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_activities")
data class DailyActivity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val time: String,
    val activity: String,
    val imageResId: Int
)
