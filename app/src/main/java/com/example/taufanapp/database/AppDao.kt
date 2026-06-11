/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Query("SELECT * FROM daily_activities")
    suspend fun getAllActivities(): List<DailyActivity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivities(activities: List<DailyActivity>)

    @Query("SELECT * FROM friends")
    suspend fun getAllFriends(): List<Friend>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFriends(friends: List<Friend>)

    @Query("SELECT * FROM gallery")
    suspend fun getAllGallery(): List<Gallery>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGallery(gallery: List<Gallery>)

    @Query("SELECT * FROM music_favorites")
    suspend fun getAllMusic(): List<Music>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusic(music: List<Music>)
}
