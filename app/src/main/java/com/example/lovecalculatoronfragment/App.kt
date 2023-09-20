package com.example.lovecalculatoronfragment

import android.app.Application
import androidx.room.Room
import com.example.lovecalculatoronfragment.model.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(applicationContext,AppDataBase::class.java, "love-file")
            .allowMainThreadQueries()// NADO SPROSIT DLYA CHEGO ETO
            .build()
    }
}