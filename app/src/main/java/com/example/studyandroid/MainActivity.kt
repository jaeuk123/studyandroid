package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.studyandroid.adapter.MainViewPagerAdapter
import com.example.studyandroid.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tabTitleArray = arrayOf(
        "Tab1","Tab2"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpager = binding.MainViewPager2
        val mainTabLayout = binding.MainTabLayout

        viewpager.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(mainTabLayout, viewpager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()

    }
}