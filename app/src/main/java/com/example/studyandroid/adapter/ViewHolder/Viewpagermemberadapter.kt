package com.example.studyandroid.adapter.ViewHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studyandroid.Data.RoomDTO.UserObject
import com.example.studyandroid.R
import com.example.studyandroid.adapter.ViewHolder.Viewpagermemberadapter.*
import java.util.ArrayList

class Viewpagermemberadapter (private val context: Context,
                              private val datas : List<UserObject>):
    RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_layout_member,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val memberId = itemView.findViewById<TextView>(R.id.member_id)
        private val memberName = itemView.findViewById<TextView>(R.id.member_Name)
        private val memberAge = itemView.findViewById<TextView>(R.id.member_age)
        private val memberDate = itemView.findViewById<TextView>(R.id.member_createDate)

        fun bind(userObject: UserObject) {
            memberId.text = userObject.id.toString()
            memberName.text = userObject.name
            memberAge.text = userObject.age
            memberDate.text = userObject.Date
        }

    }

}