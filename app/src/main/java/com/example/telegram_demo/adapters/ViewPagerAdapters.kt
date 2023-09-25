package com.example.telegram_demo.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.telegram_demo.fragments.chats.ChatsFragment
import com.example.telegram_demo.fragments.group.GroupFragment

class ViewPagerAdapters(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            ChatsFragment()
        } else {
            GroupFragment()
        }
    }
}