package com.example.gallery

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.gallery.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var _binding: FragmentSignInBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setMenuVisibility(true)
        }

        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSignInSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
        }
        binding.buttonSignInSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment2)
        }
    }
}