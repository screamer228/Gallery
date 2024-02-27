package com.example.gallery.fragment_sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.gallery.R
import com.example.gallery.databinding.FragmentSignUpBinding
import com.example.gallery.model.User
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class SignUpFragment : MvpAppCompatFragment(), SignUpView {

    private lateinit var _binding: FragmentSignUpBinding
    private val binding get() = _binding

    @Inject
    lateinit var presenterProvider: Provider<SignUpPresenter>

    private val presenter: SignUpPresenter by moxyPresenter { presenterProvider.get() }

    private val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    private var selectedDate: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.signUp_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.signUpBirthday.editText?.setOnClickListener {
            showDatePicker()
        }

        binding.buttonSignUpSignUp.setOnClickListener {
            lifecycleScope.launch{
                presenter.signUpClicked(
                    userName = binding.signUpUsername.editText?.text.toString(),
                    birthday = binding.signUpBirthday.editText?.text.toString(),
                    phoneNumber = binding.signUpPhone.editText?.text.toString(),
                    email = binding.signUpEmail.editText?.text.toString(),
                    password = binding.signUpPassword.editText?.text.toString(),
                    confirmPassword = binding.signUpConfirmPassword.editText?.text.toString()
                )
            }
        }

        binding.buttonSignUpSignIn.setOnClickListener {
            presenter.signInClicked()
        }
    }
    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()
        picker.addOnPositiveButtonClickListener { milliseconds ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = milliseconds
            selectedDate = dateFormatter.format(calendar.time)
            binding.signUpBirthday.editText?.setText(selectedDate)
        }
        picker.show(parentFragmentManager, picker.toString())
    }
    override fun showMainScreen() {
        findNavController().navigate(R.id.action_signUpFragment_to_mainFragment)
    }
    override fun showSignInScreen() {
        findNavController().navigate(R.id.action_signUpFragment_to_signInFragment2)
    }
    override fun showUserInsertionError(state: SignUpViewState) {
        when (state) {
            is SignUpViewState.UserName -> {
                binding.signUpUsername.error = state.error
            }

            is SignUpViewState.Phone -> {
                binding.signUpPhone.error = state.error
            }

            is SignUpViewState.Email -> {
                binding.signUpEmail.error = state.error
            }

            is SignUpViewState.Password -> {
                binding.signUpPassword.error = state.error
            }

            is SignUpViewState.ConfirmPassword -> {
                binding.signUpConfirmPassword.error = state.error
            }
        }
    }
}