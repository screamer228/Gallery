package com.example.gallery.repository

import com.example.gallery.model.User
import com.example.gallery.room.UserDao
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val userDao: UserDao) : RoomRepository {


    override fun getUser(username: String, password: String) : User? {
        return userDao.getUser(username, password)
    }

    override fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    companion object{
        const val DATABASE_NAME = "user-database"
    }
}