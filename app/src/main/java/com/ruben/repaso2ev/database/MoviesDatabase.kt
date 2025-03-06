package com.ruben.repaso2ev.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun getMoviesDao(): MovieDao
}