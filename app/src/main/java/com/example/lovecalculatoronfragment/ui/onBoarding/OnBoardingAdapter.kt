package com.example.lovecalculatoronfragment.ui.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculatoronfragment.R
import com.example.lovecalculatoronfragment.databinding.ItemOnBoardingBinding
import com.example.lovecalculatoronfragment.model.OnBoardingModel

class OnBoardingAdapter(private val onClick:()->Unit) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){


    private val data = arrayListOf(

        OnBoardingModel( "Have a good time",
            "You should take a time to help those who need you",
            R.raw.animation_1p),
        OnBoardingModel("Cherishing love",
            "its now no longer possible for you to cherish love",
            R.raw.animation_l2p),
        OnBoardingModel("Have a break up",
            "We have made the correction for you dont worry Maybe someone waiting for you",
            R.raw.animation_3p)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }
    override fun getItemCount(): Int {
        return data.size
    }
    inner class OnBoardingViewHolder(private val binding:ItemOnBoardingBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(onBoarding: OnBoardingModel){
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            binding.animationView.setAnimation(onBoarding.lottie)

            binding.btnStart.isVisible= adapterPosition==data.lastIndex
            binding.skip.isVisible= adapterPosition!=data.lastIndex
            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.skip.setOnClickListener {
                onClick()
            }
        }
    }
}