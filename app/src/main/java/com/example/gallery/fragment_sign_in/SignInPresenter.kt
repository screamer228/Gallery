package com.example.gallery.fragment_sign_in

import com.example.gallery.validation.ValidationSignIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import moxy.MvpPresenter
import javax.inject.Inject


class SignInPresenter @Inject constructor(
    private val validationSignIn: ValidationSignIn
) : MvpPresenter<SignInView>() {

    suspend fun signInClicked(email: String, password: String) {
        if (validateUserData(email, password)) {
            viewState.showMainScreen()
        }
    }

    fun signUpClicked() {
        viewState.showSignUpScreen()
    }

    fun cancelClicked(){
        viewState.showWelcomeScreen()
    }

    private suspend fun validateUserData(email: String, password: String
    ): Boolean = withContext(Dispatchers.Main) {

        val emailError = validationSignIn.validateUsername(email)
        val passwordError = validationSignIn.validatePassword(email, password)

        viewState.showUserInsertionError(SignInViewState.Email(emailError))
        viewState.showUserInsertionError(SignInViewState.Password(passwordError))

        return@withContext (emailError == null) && (passwordError == null)
    }
}