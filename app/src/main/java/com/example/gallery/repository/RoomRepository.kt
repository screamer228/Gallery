package com.example.gallery.repository

import com.example.gallery.presentation.model.User

interface RoomRepository {

    suspend fun getUser(email: String): User?

    suspend fun insertUser(user: User)

}