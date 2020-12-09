package com.example.toboc.weatherapi.viewmodel

import android.content.SharedPreferences

interface ViewModelContract {
    fun saveUserPref(zipCode : String, option : Boolean, metrics: Boolean)
    fun initSharePref() : SharedPreferences
    val mZipCode : String
    val mOptional : Boolean
    val mImperial: Boolean
    fun readUserPref()
}
