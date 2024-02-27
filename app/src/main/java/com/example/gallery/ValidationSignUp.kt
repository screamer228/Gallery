package com.example.gallery

import android.content.Context
import com.example.gallery.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ValidationSignUp @Inject constructor(
    private val roomRepository: RoomRepository,
    private val context: Context,
) {
    fun validateUserName(username: String): String? {
        return if (username.length < 3) {
            context.getString(R.string.username_too_short)
        } else {
            null
        }
    }

    fun validatePhoneNumber(phoneNumber: String): String? {
        val isCorrect: Boolean = phoneNumber.length == 12
        return if (isCorrect) {
            null
        } else {
            context.getString(R.string.incorrect_number)
        }
    }

    suspend fun validateEmail(email: String): String? {
        var isAlreadyRegistered: Boolean
        withContext(Dispatchers.IO) {
            isAlreadyRegistered = roomRepository.getUser(email) != null
        }
        return if(isAlreadyRegistered){
            context.getString(R.string.email_already_registered)
        } else
            null
    }

    fun validatePassword(password: String): String? {
        return if (password.length < 8) {
            context.getString(R.string.password_less_then_8)
        } else {
            null
        }
    }

    fun validateConfirmPassword(firstPassword: String, secondPassword: String): String? {
        return if (firstPassword != secondPassword) {
            context.getString(R.string.passwords_dont_match)
        } else {
            null
        }
    }
}