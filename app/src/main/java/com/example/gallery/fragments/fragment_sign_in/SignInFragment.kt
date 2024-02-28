package com.example.gallery.fragments.fragment_sign_in

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gallery.R
import com.example.gallery.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class SignInFragment : MvpAppCompatFragment(), SignInView {

    private lateinit var _binding: FragmentSignInBinding
    private val binding get() = _binding

    @Inject
    lateinit var presenterProvider: Provider<SignInPresenter>

    private val presenter: SignInPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListeners()
    }

    private fun clickListeners(){
        binding.signInCancel.setOnClickListener {
            presenter.cancelClicked()
        }

        binding.buttonSignInSignIn.setOnClickListener {
            lifecycleScope.launch {
                presenter.signInClicked(
                    email = binding.signInEmail.editText?.text.toString(),
                    password = binding.signInPassword.editText?.text.toString()
                )
            }
        }

        binding.buttonSignInSignUp.setOnClickListener {
            presenter.signUpClicked()
        }

        //переключение видимости пароля
        binding.signInPassword.setEndIconOnClickListener {
            val editTextPassword = binding.signInPassword.editText
            val isPasswordVisible = editTextPassword?.inputType != InputType.TYPE_TEXT_VARIATION_PASSWORD
            editTextPassword?.inputType =
                if (isPasswordVisible) InputType.TYPE_TEXT_VARIATION_PASSWORD
                else InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            val endIconDrawable =
                if (isPasswordVisible) R.drawable.ic_eye_off
                else R.drawable.ic_eye_on
            binding.signInPassword.endIconDrawable = ContextCompat.getDrawable(requireContext(), endIconDrawable)
        }
    }

    override fun showMainScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
    }
    override fun showSignUpScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
    }
    override fun showWelcomeScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)
    }
    override fun showUserInsertionError(state: SignInViewState) {
        when (state) {

            is SignInViewState.Email -> {
                binding.signInEmail.error = state.error
            }

            is SignInViewState.Password -> {
                binding.signInPassword.error = state.error
            }
        }
    }
}