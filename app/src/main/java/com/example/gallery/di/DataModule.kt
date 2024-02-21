package com.example.gallery.di

import android.content.Context
import androidx.room.Room
import com.example.gallery.repository.RoomRepositoryImpl.Companion.DATABASE_NAME
import com.example.gallery.room.UserDao
import com.example.gallery.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun providesToDoDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()

}