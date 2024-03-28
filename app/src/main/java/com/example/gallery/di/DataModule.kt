package com.example.gallery.di

import android.content.Context
import androidx.room.Room
import com.example.gallery.validation.ValidationSignUp
import com.example.gallery.data.mapper.UserMapper
import com.example.gallery.data.repository.RoomRepositoryImpl
import com.example.gallery.data.room.UserDao
import com.example.gallery.data.room.UserDatabase
import com.example.gallery.repository.RoomRepository
import com.example.gallery.validation.ValidationSignIn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesValidationSignIn(
        roomRepository: RoomRepository, @ApplicationContext context: Context
    ): ValidationSignIn = ValidationSignIn(roomRepository, context)

    @Provides
    @Singleton
    fun providesValidationSignUp(
        roomRepository: RoomRepository, @ApplicationContext context: Context
    ): ValidationSignUp = ValidationSignUp(roomRepository, context)

    @Provides
    @Singleton
    fun providesRoomRepository(userDao: UserDao): RoomRepository = RoomRepositoryImpl(
        userDao, userMapper = UserMapper()
    )

    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesToDoDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()

    companion object {
        const val DATABASE_NAME = "user-database"
    }
}

