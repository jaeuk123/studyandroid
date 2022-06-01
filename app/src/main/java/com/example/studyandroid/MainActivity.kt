package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.viewpager2.widget.ViewPager2
import com.example.studyandroid.Data.RoomDTO.UserObject
import com.example.studyandroid.Data.RoomDatabase.UserDatabase
import com.example.studyandroid.adapter.MainViewPagerAdapter
import com.example.studyandroid.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,"test-db"
        ).build()

//        runBlocking {
//            delay(1000L)
//            val onlyDate: LocalDateTime = LocalDateTime.now()
//            val ofPattern = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
//            db.userDao().insertUser(UserObject("1","1",onlyDate.format(ofPattern)))
//            Log.d("DB SAVE DATA","SAVED")
//
//            readdata(db)
//        }


    }
    suspend fun readdata(db:UserDatabase) = coroutineScope {
        withContext(Dispatchers.IO) {
            var user = db.userDao().searchAllUser()
            for (i:Int in 0 until user.size){
                Log.d("DB ALL VALUE : ","${user[i].name} ${user[i].id} ${user[i].Date}")
            }
        }
    }

}