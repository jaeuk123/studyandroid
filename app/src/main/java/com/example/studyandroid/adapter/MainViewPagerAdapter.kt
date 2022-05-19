package com.example.studyandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.studyandroid.Fragment.MainViewPager.MainFirstFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
        FragmentStateAdapter(fragmentManager, lifecycle){

    private val fragmentcount = 2

    override fun getItemCount(): Int {
        return fragmentcount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MainFirstFragment()
            else ->{
                MainFirstFragment()
            }
        }
    }

}