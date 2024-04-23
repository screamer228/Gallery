package com.example.gallery.presentation.fragments.fragment_sign_up

sealed interface SignUpViewState {

    data class UserName(val error: String?) : SignUpViewState
    data class Phone(val error: String?) : SignUpViewState
    data class Email(val error: String?) : SignUpViewState
    data class Password(val error: String?) : SignUpViewState
    data class ConfirmPassword(val error: String?) : SignUpViewState

}