package com.example.lovecalculatoronfragment.module

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lovecalculatoronfragment.model.LoveApi
import com.example.lovecalculatoronfragment.model.room.AppDataBase
import com.example.lovecalculatoronfragment.model.room.LoveDao
import com.example.lovecalculatoronfragment.model.room.Pref.Companion.PREF_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module //class v kotorom my sozdaem objecty
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideApi(): LoveApi {  // returning Api     // provider eto -vse funcksii kotoryi daet dostup k dr obektam
        return  Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApi::class.java)
    }

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "love-file")
            .allowMainThreadQueries().build()
    }
    @Provides
    fun provideLoveDao(appDataBase: AppDataBase): LoveDao {
        return appDataBase.loveDao()
    }

    @Provides
    fun providePref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }


}