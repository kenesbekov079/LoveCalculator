package com.example.lovecalculatoronfragment.ui.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculatoronfragment.R
import com.example.lovecalculatoronfragment.databinding.FragmentOnBoardingBinding
import com.example.lovecalculatoronfragment.model.room.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var  pref: Pref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager)
    }
    private fun onClick() {
        pref.onBoardingShowed()
        findNavController().navigateUp()
    }

}