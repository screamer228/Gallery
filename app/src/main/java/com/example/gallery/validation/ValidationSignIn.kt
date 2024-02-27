package com.example.gallery.validation

import android.content.Context
import com.example.gallery.R
import com.example.gallery.model.User
import com.example.gallery.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ValidationSignIn(
    private val databaseRepository: RoomRepository,
    private val context: Context,
) {

    suspend fun validateUsername(email: String): String? {
        val user: User?
        withContext(Dispatchers.IO) {
            user = databaseRepository.getUser(email)
        }
        return if (user == null) {
            context.getString(R.string.user_not_found)
        } else {
            null
        }
    }

    suspend fun validatePassword(email: String, password: String): String? {
        val user: User?
        withContext(Dispatchers.IO) {
            user = databaseRepository.getUser(email)
        }
        return if (user == null) {
            context.getString(R.string.invalid_password)
        } else {
            if (user.password != password) {
                context.getString(R.string.invalid_password)
            } else {
                null
            }
        }
    }
}