package com.example.gallery.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gallery.data.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun getUser(username: String, password: String): UserEntity?

    @Insert
    fun insertUser(user: UserEntity)

}