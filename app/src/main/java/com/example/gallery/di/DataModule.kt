package com.example.gallery.di

import android.content.Context
import androidx.room.Room
import com.example.gallery.fragment_sign_up.SignUpPresenter
import com.example.gallery.data.mapper.UserMapper
import com.example.gallery.data.repository.RoomRepositoryImpl
import com.example.gallery.data.repository.RoomRepositoryImpl.Companion.DATABASE_NAME
import com.example.gallery.data.room.UserDao
import com.example.gallery.data.room.UserDatabase
import com.example.gallery.repository.RoomRepository
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
    fun provideSignUpPresenter(roomRepository: RoomRepository): SignUpPresenter {
        return SignUpPresenter(roomRepository)
    }

    @Singleton
    @Provides
    fun providesRoomRepository(userDao: UserDao): RoomRepository = RoomRepositoryImpl(
        userDao, userMapper = UserMapper()
    )

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