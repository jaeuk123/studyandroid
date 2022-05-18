package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.studyandroid.adapter.MainViewPagerAdapter
import com.example.studyandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpager = binding.MainViewPager2
        viewpager.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)

    }
}