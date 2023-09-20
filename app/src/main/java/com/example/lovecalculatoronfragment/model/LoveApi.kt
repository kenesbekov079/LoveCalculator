package com.example.lovecalculatoronfragment.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    //https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
      @GET("getPercentage")
    fun calculateMatching(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "54031b3347msha7121e7da22237cp1a11edjsn85f45f28f80c",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}