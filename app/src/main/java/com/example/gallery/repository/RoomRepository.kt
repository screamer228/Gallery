package com.example.gallery.repository

import com.example.gallery.model.User

interface RoomRepository {

    fun getUser(username: String, password: String) : User?

    fun insertUser(user: User)

}