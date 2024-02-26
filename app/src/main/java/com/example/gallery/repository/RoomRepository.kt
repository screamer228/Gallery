package com.example.gallery.repository

import com.example.gallery.model.User

interface RoomRepository {

    fun getUser(email: String) : User?

    fun insertUser(user: User)

}