package com.example.toboc.weatherapi.view

import android.content.Intent

interface ViewContract{
    interface LandingActivityContract{
        fun checkPreviousUserPref() : Boolean
        fun getPreviousUserPref()
        fun openSettingsActivity()
        fun implementBinding()
    }
    interface  SettingsActivityContract{
        fun updateSP(zipCode : String, optional : Boolean, metrics: Boolean)
    }
}