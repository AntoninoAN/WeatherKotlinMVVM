package com.example.toboc.weatherapi.ViewModel

import android.content.SharedPreferences

interface ViewModelContract {
    fun saveUserPref(zipCode : String, option : Boolean)
    fun initSharePref() : SharedPreferences
    val mZipCode : String
    val mOptional : Boolean
    fun readUserPref()
}
