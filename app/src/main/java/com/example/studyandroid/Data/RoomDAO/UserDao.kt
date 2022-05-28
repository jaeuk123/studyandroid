package com.example.studyandroid.Data.RoomDAO

import androidx.room.*
import com.example.studyandroid.Data.RoomDTO.UserObject

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userObject: UserObject)

    @Update
    suspend fun updateUser(userObject: UserObject)

    @Delete
    suspend fun deleteUser(userObject: UserObject)

    @Query("SELECT * FROM UserObject")
    suspend fun searchAllUser() : List<UserObject>
}