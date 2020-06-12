package com.example.midterm_2

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Health::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getHealthDao(): HealthDao
}