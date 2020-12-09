package com.example.toboc.weatherapi.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.content.SharedPreferences
import com.example.toboc.weatherapi.common.ConstantVals
import com.example.toboc.weatherapi.common.CustomApp


class WeatherViewModel(val mApp : Application) : ViewModelContract, AndroidViewModel(mApp) {

    override val mZipCode: String by lazy {
        initSharePref().getString(ConstantVals.zipCodeKey, "")
    }
    override val mOptional: Boolean by lazy {
        initSharePref().getBoolean(ConstantVals.optionKey, false)
    }
    override val mImperial: Boolean by lazy{
        initSharePref().getBoolean(ConstantVals.optionMetrics, false)
    }

    override fun readUserPref() {
        initSharePref().getString(ConstantVals.zipCodeKey, "")
        initSharePref().getBoolean(ConstantVals.optionKey, false)
        initSharePref().getBoolean(ConstantVals.optionMetrics, false)
    }

    /**
     * Get SP object
     * todo this could be singleton
     * todo basic definition of Singleton class is
     * todo a Singleton, so previous statement is wrong.
     */
    override fun initSharePref(): SharedPreferences {
       return mApp.applicationContext.getSharedPreferences(ConstantVals.sharedPrefFile, Context.MODE_PRIVATE)
    }

    /**
     * Save Zip Code and Optional into SP
     * Using apply because not actual Singleton impl so far...
     */
    override fun saveUserPref(zipCode: String, option: Boolean, metrics: Boolean) {
        initSharePref().edit().putString(ConstantVals.zipCodeKey, zipCode).apply()
        initSharePref().edit().putBoolean(ConstantVals.optionKey, option).apply()
    }
//    private final val binder : IService.Stub =
}