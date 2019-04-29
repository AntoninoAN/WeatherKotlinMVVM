package com.example.toboc.weatherapi.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.SharedPreferences
import com.example.toboc.weatherapi.Common.ConstantVals


class ViewModel(val mApp : Application) : ViewModelContract, AndroidViewModel(mApp) {

    override val mZipCode: String by lazy {
        initSharePref().getString(ConstantVals().zipCodeKey, "")
    }
    override val mOptional: Boolean by lazy {
        initSharePref().getBoolean(ConstantVals().optionKey, false)
    }

    override fun readUserPref() {
        initSharePref().getString(ConstantVals().zipCodeKey, "")
        initSharePref().getBoolean(ConstantVals().optionKey, false)
    }

    /**
     * Get SP object
     * todo this could be singleton
     * todo basic definition of Singleton class is
     * todo a Singleton, so previous statement is wrong.
     */
    override fun initSharePref(): SharedPreferences {
       return mApp.applicationContext.getSharedPreferences(ConstantVals().sharedPrefFile, Context.MODE_PRIVATE)
    }

    /**
     * Save Zip Code and Optional into SP
     * Using apply because not actual Singleton impl so far...
     */
    override fun saveUserPref(zipCode: String, option: Boolean) {
        initSharePref().edit().putString(ConstantVals().zipCodeKey, zipCode).apply()
        initSharePref().edit().putBoolean(ConstantVals().optionKey, option).apply()
    }
}