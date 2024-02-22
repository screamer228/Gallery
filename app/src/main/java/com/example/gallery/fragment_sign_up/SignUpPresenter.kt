package com.example.gallery.fragment_sign_up

import com.example.gallery.model.User
import com.example.gallery.repository.RoomRepository
import moxy.MvpPresenter
import javax.inject.Inject


class SignUpPresenter @Inject constructor(
    private val roomRepository: RoomRepository
) : MvpPresenter<SignUpView>() {

    fun signUpClicked(user: User) {
        if (validateUserData(user)) {
            roomRepository.insertUser(user)
            viewState.showMainScreen()
        } else {
            viewState.showUserInsertionError()
        }
    }

    fun signInClicked() {
        viewState.showSignInScreen()
    }

    private fun validateUserData(user: User): Boolean {
        // Реализация валидации данных пользователя
        return true
    }
}