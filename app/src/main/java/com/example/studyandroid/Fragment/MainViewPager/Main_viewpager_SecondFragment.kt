package com.example.studyandroid.Fragment.MainViewPager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.studyandroid.Data.RoomDTO.UserObject
import com.example.studyandroid.Data.RoomDatabase.UserDatabase
import com.example.studyandroid.adapter.ViewHolder.Viewpagermemberadapter
import com.example.studyandroid.databinding.ViewpagerSecondfragmentBinding
import kotlinx.coroutines.*

class Main_viewpager_SecondFragment : Fragment() {

    private var _binding :ViewpagerSecondfragmentBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<UserObject>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewpagerSecondfragmentBinding.inflate(inflater,container,false)

        binding.memberRecyclerview.visibility = View.VISIBLE
        val db = Room.databaseBuilder(
            requireContext().applicationContext,
            UserDatabase::class.java,"test-db"
        ).build()

        CoroutineScope(Dispatchers.Main).launch {
            readdata(db)
            binding.memberRecyclerview.adapter  = Viewpagermemberadapter(requireContext(), list)
            binding.memberRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    suspend fun readdata(db: UserDatabase) = coroutineScope {
        withContext(Dispatchers.IO) {
            var user = db.userDao().searchAllUser()
            for (i:Int in 0 until user.size){
                Log.d("DB ALL VALUE : ","${user[i].name} ${user[i].id} ${user[i].Date}")
                val userobject = UserObject(user[i].name,user[i].age,user[i].Date)
                list.add(userobject)
            }
        }
    }
}