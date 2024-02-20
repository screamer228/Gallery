package com.example.gallery.ui.login

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gallery.R
import com.example.gallery.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var _binding: FragmentSignInBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val actionBar = (activity as AppCompatActivity).supportActionBar
//        actionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//        }

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = binding.TILSignInEmail
        val passwordEditText = binding.TILSignInPassword
        val signInButton = binding.buttonSignInSingIn
        val signUpButton = binding.buttonSignUpSignUp
        val loadingProgressBar = binding.loading

    }
}