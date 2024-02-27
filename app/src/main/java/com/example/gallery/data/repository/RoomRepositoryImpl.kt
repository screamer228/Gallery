package com.example.gallery.data.repository

import com.example.gallery.data.mapper.UserMapper
import com.example.gallery.repository.RoomRepository
import com.example.gallery.data.room.UserDao
import com.example.gallery.model.User
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val userDao: UserDao, private val userMapper : UserMapper
) : RoomRepository {


    override suspend fun getUser(email: String): User? {
        val userEntity = userDao.getUser(email)
        return userEntity?.let { userMapper.fromEntity(it) }
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(userMapper.toEntity(user))
    }

}