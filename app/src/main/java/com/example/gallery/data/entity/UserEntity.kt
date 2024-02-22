package com.example.gallery.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    val userName: String,
    val birthday: String?,
    val phoneNumber: String,
    @PrimaryKey val email: String,
    val password: String
)