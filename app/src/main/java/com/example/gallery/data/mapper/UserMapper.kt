package com.example.gallery.data.mapper

import com.example.gallery.data.entity.UserEntity
import com.example.gallery.model.User
import java.util.Date

class UserMapper {

    fun fromEntity(userEntity: UserEntity?): User? {
        return if (userEntity == null) null
        else
            User(
                userName = userEntity.userName,
                birthday = userEntity.birthday,
                phoneNumber = userEntity.phoneNumber,
                email = userEntity.email,
                password = userEntity.password
            )
    }

    fun toEntity(user: User): UserEntity {
        return UserEntity(
            userName = user.userName,
            birthday = user.birthday,
            phoneNumber = user.phoneNumber,
            email = user.email,
            password = user.password
        )
    }
}