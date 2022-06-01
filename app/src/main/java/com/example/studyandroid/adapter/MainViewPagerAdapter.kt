package com.example.studyandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.studyandroid.Fragment.MainViewPager.Main_viewpager_FirstFragment
import com.example.studyandroid.Fragment.MainViewPager.Main_viewpager_SecondFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
        FragmentStateAdapter(fragmentManager, lifecycle){

    private val fragmentcount = 2

    override fun getItemCount(): Int {
        return fragmentcount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Main_viewpager_FirstFragment()
            else ->{
                Main_viewpager_SecondFragment()
            }
        }
    }

}