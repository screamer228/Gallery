package com.example.gallery.data.mapper

import com.example.gallery.data.entity.UserEntity
import com.example.gallery.model.User
import java.util.Date

class UserMapper {

    fun fromEntity(userEntity: UserEntity): User {
        val birthday = userEntity.birthday?.let { Date(it) }
        return User(
            userName = userEntity.userName,
            birthday = userEntity.birthday,
            phoneNumber = userEntity.phoneNumber,
            email = userEntity.email,
            password = userEntity.password
        )
    }

    fun toEntity(user: User): UserEntity {
        val birthdayInMillis = user.birthday
        return UserEntity(
            userName = user.userName,
            birthday = birthdayInMillis,
            phoneNumber = user.phoneNumber,
            email = user.email,
            password = user.password
        )
    }
}