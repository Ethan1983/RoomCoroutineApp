package com.sample.roomcoroutineapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = [Info::class], version = 1, exportSchema = false )
abstract class AppDatabase : RoomDatabase() {

    abstract fun infoDao() : InfoDao
}