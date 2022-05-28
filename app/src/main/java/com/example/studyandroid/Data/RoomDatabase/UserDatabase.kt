package com.example.studyandroid.Data.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studyandroid.Data.RoomDAO.UserDao
import com.example.studyandroid.Data.RoomDTO.UserObject

@Database(entities = [UserObject::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao


    companion object{
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context : Context): UserDatabase{
            if (instance == null){
                synchronized(UserDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user-database"
                    ).build()
                }
            }
            return instance!!
        }
    }
}