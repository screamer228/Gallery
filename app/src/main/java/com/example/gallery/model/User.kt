package com.example.gallery.model

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey val userId: String,
    val userName: String,
    val birthday: Long?,
    val phoneNumber: String,
    val email: String,
    val password: String,
)