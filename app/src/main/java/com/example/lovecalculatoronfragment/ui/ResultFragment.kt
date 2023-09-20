package com.example.lovecalculatoronfragment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculatoronfragment.R
import com.example.lovecalculatoronfragment.databinding.FragmentResultBinding
import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.presenter.Presenter
import com.example.lovecalculatoronfragment.presenter.ResultPresenter
import com.example.lovecalculatoronfragment.view.ResultView


class ResultFragment : Fragment(),ResultView {
    private lateinit var binding:FragmentResultBinding
    private val resultPresenter = ResultPresenter(this)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
       var  result=  this.arguments?.getSerializable("love") as LoveModel // получаем данные
        resultPresenter.getData(result)

    }

    override fun showLove(loveModel: LoveModel) {
        with(binding){
            fnameTV.text = loveModel.firstName
            snameTV.text = loveModel.secondName
            percentageTV.text = loveModel.percentage
            resultTV.text = loveModel.result
            historyImb.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)

            }

            tryBtn.setOnClickListener {
                findNavController().navigate(R.id.mainFragment)
            }

        }

    }


}