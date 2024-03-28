package com.example.gallery.repository

import com.example.gallery.model.User

interface RoomRepository {

    suspend fun getUser(email: String): User?

    suspend fun insertUser(user: User)

}