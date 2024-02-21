package com.example.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.gallery.databinding.FragmentFeedsBinding
import com.example.gallery.databinding.FragmentSignInBinding
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.textfield.TextInputLayout

class FeedsFragment : Fragment() {

    private lateinit var _binding: FragmentFeedsBinding
    private val binding get() = _binding
    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        _binding = FragmentFeedsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = binding.tabLayoutFeeds
        viewPager = binding.viewPagerFeeds

        prepareViewPager()
    }

    private fun prepareViewPager() {
        val fragmentList = arrayListOf(
            FeedsNewFragment.newInstance(),
            FeedsPopularFragment.newInstance()
        )
        val tabTitleArray = arrayOf(getString(R.string.New), getString(R.string.Popular))

        viewPager.adapter = ViewPagerAdapter(requireActivity(), fragmentList)

        TabLayoutMediator(tabLayout, viewPager) {
                tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}