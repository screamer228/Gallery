package com.example.gallery.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gallery.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): User?

    @Insert
    fun insertUser(user: User)

}