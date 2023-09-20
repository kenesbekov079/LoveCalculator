package com.example.lovecalculatoronfragment.view

import com.example.lovecalculatoronfragment.model.LoveModel

interface  LoveView {
    fun navigationToResultScreen(loveModel: LoveModel)
    fun showError(error: String)
    fun navigationToOnBoarding()


}