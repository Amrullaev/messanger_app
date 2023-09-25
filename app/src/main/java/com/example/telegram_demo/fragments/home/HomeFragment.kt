package com.example.telegram_demo.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.telegram_demo.R
import com.example.telegram_demo.adapters.ViewPagerAdapters
import com.example.telegram_demo.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    lateinit var viewPagerAdapters: ViewPagerAdapters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewPagerAdapters = ViewPagerAdapters(this@HomeFragment)

            val tabTitle = arrayOf("Chats", "Groups")
            viewPager.adapter = viewPagerAdapters
            TabLayoutMediator(
                tabLayout,
                viewPager
            ) { tab, position ->
                tab.text = tabTitle[position]
            }.attach()
        }
    }


}