package com.example.lovecalculatoronfragment.presenter

import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.view.ResultView

class ResultPresenter (private val resultView: ResultView){
    fun getData(loveModel: LoveModel){
        resultView.showLove(loveModel)
    }
}