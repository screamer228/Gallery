package com.example.gallery.fragment_sign_up

import com.example.gallery.validation.ValidationSignUp
import com.example.gallery.model.User
import com.example.gallery.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import moxy.MvpPresenter
import javax.inject.Inject


class SignUpPresenter @Inject constructor(
    private val roomRepository: RoomRepository,
    private val validationSignUp: ValidationSignUp
) : MvpPresenter<SignUpView>() {

    suspend fun signUpClicked(
        userName: String,
        birthday: String?,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (validateUserData(
            userName,
            phoneNumber,
            email,
            password,
            confirmPassword
        )) {
            val user = User(
                userName,
                birthday,
                phoneNumber,
                email,
                password
            )
            roomRepository.insertUser(user)
            viewState.showMainScreen()
        }
    }

    fun signInClicked() {
        viewState.showSignInScreen()
    }

    fun cancelClicked(){
        viewState.showWelcomeScreen()
    }

    private suspend fun validateUserData(
        userName: String,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String,
        ): Boolean = withContext(Dispatchers.Main) {

            val userNameError = validationSignUp.validateUserName(userName)
            val phoneNumberError = validationSignUp.validatePhoneNumber(phoneNumber)
            val emailError = validationSignUp.validateEmail(email)
            val passwordError = validationSignUp.validatePassword(password)
            val confirmPasswordError = validationSignUp.validateConfirmPassword(password, confirmPassword)

            viewState.showUserInsertionError(SignUpViewState.UserName(userNameError))
            viewState.showUserInsertionError(SignUpViewState.Phone(phoneNumberError))
            viewState.showUserInsertionError(SignUpViewState.Email(emailError))
            viewState.showUserInsertionError(SignUpViewState.Password(passwordError))
            viewState.showUserInsertionError(SignUpViewState.ConfirmPassword(confirmPasswordError))

            return@withContext userNameError == null && phoneNumberError == null
                    && emailError == null && passwordError == null
                    && confirmPasswordError == null
        }
}