package com.example.studyandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.studyandroid.Fragment.MainViewPager.MainFirstFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):
        FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> return MainFirstFragment()
            else ->{
                return MainFirstFragment()
            }
        }
    }

}