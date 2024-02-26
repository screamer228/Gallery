package com.example.gallery.fragment_sign_in

import com.example.gallery.repository.RoomRepository
import moxy.MvpPresenter
import javax.inject.Inject


class SignInPresenter @Inject constructor(
    private val roomRepository: RoomRepository
) : MvpPresenter<SignInView>() {

    fun signInClicked(email: String) {
        if (validateUserData(email)) {
            val receivedUser = roomRepository.getUser(email)
            if (receivedUser != null){
                viewState.showMainScreen()
            }
            else {
                viewState.showUserInsertionError()
            }
        } else {
            viewState.showUserInsertionError()
        }
    }

    fun signUpClicked() {
        viewState.showSignUpScreen()
    }

    private fun validateUserData(email: String): Boolean {
        // Реализация валидации данных пользователя
        return true
    }
}