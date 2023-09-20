package com.example.lovecalculatoronfragment.presenter

import com.example.lovecalculatoronfragment.model.LoveApi
import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.model.RetrofitService.api
import com.example.lovecalculatoronfragment.model.room.LoveDao
import com.example.lovecalculatoronfragment.model.room.Pref
import com.example.lovecalculatoronfragment.view.LoveView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import javax.inject.Inject

class Presenter @Inject constructor(private val api: LoveApi) {

    private lateinit var loveView: LoveView

    @Inject
    lateinit var loveDao: LoveDao

    @Inject
    lateinit var pref: Pref

    fun getLoveResult(firstName: String,secondName:String){
        api.calculateMatching(
            firstName,
            secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {
                    val loveModel = it
                    loveModel.time = Date().time
                    loveDao.insert(loveModel)
                    loveView.navigationToResultScreen(loveModel)



                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }

        })
    }
    fun showOnBoarding(){
        if (!pref.isOnBoardingShowed())
            loveView.navigationToOnBoarding()
    }
    fun attchView(view:LoveView){
         loveView = view
    }

}