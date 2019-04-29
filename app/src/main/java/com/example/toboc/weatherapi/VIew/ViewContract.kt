package com.example.toboc.weatherapi.VIew

import android.content.Intent

interface ViewContract{
    interface LandingActivityContract{
        fun checkPreviousUserPref() : Boolean
        fun openSettingsActivity()
    }
    interface  SettingsActivityContract{
        fun readPreviousSP()
        fun checkIntent(intent : Intent?)
        fun updateSP(zipCode : String, optional : Boolean)
    }
}