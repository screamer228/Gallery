package com.example.gallery.fragment_sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gallery.R
import com.example.gallery.databinding.FragmentSignInBinding
import com.google.android.material.appbar.MaterialToolbar
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

        val toolbar = view.findViewById<MaterialToolbar>(R.id.signIn_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
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
    }

    override fun showMainScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
    }

    override fun showSignUpScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_signUpFragment2)
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