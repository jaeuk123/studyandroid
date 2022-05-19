package com.example.studyandroid.Fragment.MainViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studyandroid.databinding.ViewpagerFirstfragmentBinding

class MainFirstFragment : Fragment() {

    private var _binding: ViewpagerFirstfragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ViewpagerFirstfragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewpagerTextview.text = "생성"
        super.onViewCreated(view, savedInstanceState)
    }
}