package com.example.lovecalculatoronfragment.model.room

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val preferences: SharedPreferences) {

    fun isOnBoardingShowed(): Boolean {
        return preferences.getBoolean(SHOWED_KEY, false)
    }

    fun onBoardingShowed() {
        preferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun onBoardingShow() {
        preferences.edit().putBoolean(SHOWED_KEY, false).apply()
    }


    companion object{
        const val PREF_NAME="pref.name"
        const val SHOWED_KEY="seen.key"
        const val NAME_KEY="name.key"
        const val IMAGE_KEY="image.key"
    }
}