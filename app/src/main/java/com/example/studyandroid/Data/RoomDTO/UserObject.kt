package com.example.studyandroid.Data.RoomDTO

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserObject (
    var name: String,
    var age : String,
    var Date : String
        ){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
