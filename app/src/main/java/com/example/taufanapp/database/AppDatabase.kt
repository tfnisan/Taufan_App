/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taufanapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [DailyActivity::class, Friend::class, Gallery::class, Music::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "taufan_app_db"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.appDao())
                }
            }
        }

        suspend fun populateDatabase(appDao: AppDao) {
            // Data Daily Activity
            val activities = listOf(
                DailyActivity(time = "04.30", activity = "Bangun Pagi", imageResId = android.R.drawable.ic_lock_idle_alarm),
                DailyActivity(time = "04.45", activity = "Shalat Subuh", imageResId = android.R.drawable.ic_menu_today),
                DailyActivity(time = "05.00 - 07.00", activity = "Olahraga Lari", imageResId = android.R.drawable.ic_menu_directions),
                DailyActivity(time = "07.00 - 07.30", activity = "Mandi & Sarapan", imageResId = android.R.drawable.ic_menu_set_as),
                DailyActivity(time = "08.00 - 09.00", activity = "Zoom Meet Harian Kantor", imageResId = android.R.drawable.stat_notify_chat),
                DailyActivity(time = "09.00 - 11.30", activity = "Bekerja WFH", imageResId = android.R.drawable.ic_menu_edit),
                DailyActivity(time = "11.30 - 13.00", activity = "Istirahat Shalat Makan", imageResId = android.R.drawable.ic_menu_today),
                DailyActivity(time = "13.00 - 16.00", activity = "Bekerja", imageResId = android.R.drawable.ic_menu_edit),
                DailyActivity(time = "16.00", activity = "Shalat Ashar", imageResId = android.R.drawable.ic_menu_today),
                DailyActivity(time = "16.00 - 17.00", activity = "Mengerjakan Tugas Kuliah", imageResId = android.R.drawable.ic_menu_agenda),
                DailyActivity(time = "17.00 - 18.00", activity = "Berangkat Kuliah", imageResId = android.R.drawable.ic_menu_mylocation),
                DailyActivity(time = "18.00 - 21.00", activity = "Kuliah", imageResId = android.R.drawable.ic_menu_view),
                DailyActivity(time = "21.00 - 04.00", activity = "Istirahat Tidur", imageResId = android.R.drawable.ic_lock_power_off)
            )
            appDao.insertActivities(activities)

            // Data Friends
            val friends = listOf(
                Friend(name = "Enjang Suherlan", imageResId = android.R.drawable.ic_menu_gallery),
                Friend(name = "Adrian Satria Putra", imageResId = android.R.drawable.ic_menu_gallery),
                Friend(name = "Riska Paradila", imageResId = android.R.drawable.ic_menu_gallery),
                Friend(name = "Muhammad Faisal", imageResId = android.R.drawable.ic_menu_gallery),
                Friend(name = "Muhammad Nathan", imageResId = android.R.drawable.ic_menu_gallery),
                Friend(name = "Dimas Nurfauzi", imageResId = android.R.drawable.ic_menu_gallery)
            )
            appDao.insertFriends(friends)

            // Data Music
            val musics = listOf(
                Music(title = "Night Changes", artist = "One Direction"),
                Music(title = "I Think They Call This Love", artist = "Matthew Ifield"),
                Music(title = "Blue", artist = "Yung Kai")
            )
            appDao.insertMusic(musics)

            // Data Gallery
            val galleries = listOf(
                Gallery(imageResId = R.drawable.galeri_1, description = "Foto 1"),
                Gallery(imageResId = R.drawable.galeri_2, description = "Foto 2"),
                Gallery(imageResId = R.drawable.galeri_3, description = "Foto 3"),
                Gallery(imageResId = R.drawable.galeri_4, description = "Foto 4"),
                Gallery(imageResId = R.drawable.galeri_5, description = "Foto 5"),
                Gallery(imageResId = R.drawable.galeri_6, description = "Foto 6"),
                Gallery(imageResId = R.drawable.galeri_7, description = "Foto 7"),
                Gallery(imageResId = R.drawable.galeri_8, description = "Foto 8"),
                Gallery(imageResId = R.drawable.galeri_9, description = "Foto 9")
            )
            appDao.insertGallery(galleries)
        }
    }
}
