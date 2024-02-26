package com.example.gallery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gallery.data.entity.UserEntity

@Database(entities = [UserEntity::class],
    version = 2,
    exportSchema = false)

abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}