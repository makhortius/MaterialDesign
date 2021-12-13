package com.gb.material_1507_1544_3_1.view.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.material_1507_1555_3_1.databinding.FragmentMainBinding

class PictureOfTheDayFragment:Fragment() {

    private var _binding: FragmentMainBinding?=null
    val binding: FragmentMainBinding
    get(){
        return _binding!!
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance():PictureOfTheDayFragment{
            return PictureOfTheDayFragment()
        }
    }
}