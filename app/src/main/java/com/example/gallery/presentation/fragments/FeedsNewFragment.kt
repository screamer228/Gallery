package com.example.gallery.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.gallery.data_layout.ImagesDataList
import com.example.gallery.presentation.adapters.FeedsRecyclerAdapter
import com.example.gallery.databinding.FragmentFeedsNewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class FeedsNewFragment : Fragment() {

    private lateinit var _binding: FragmentFeedsNewBinding
    private val binding get() = _binding

    private val adapter = FeedsRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedsNewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFeedsNew.adapter = adapter

        getData()
    }

    private fun getData() {
        lifecycleScope.launch {
            binding.feedsNewLoadingContainer.visibility = VISIBLE
            delay(2000)
            val imagesList = ImagesDataList.getImages()
            withContext(Dispatchers.Main) {
                adapter.updateList(imagesList)
                binding.feedsNewLoadingContainer.visibility = INVISIBLE
            }
        }
    }

    companion object {
        fun newInstance() = FeedsNewFragment()
    }
}