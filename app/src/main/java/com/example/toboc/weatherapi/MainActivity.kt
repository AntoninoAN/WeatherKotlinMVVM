package com.example.toboc.weatherapi

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.toboc.weatherapi.Common.ConstantVals
import com.example.toboc.weatherapi.Common.CustomApp
import com.example.toboc.weatherapi.VIew.ViewContract
import com.example.toboc.weatherapi.ViewModel.ViewModel

class MainActivity : AppCompatActivity(), ViewContract.LandingActivityContract {
    val viewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(CustomApp).create(ViewModel :: class.java)
    }

    override fun checkPreviousUserPref(): Boolean {
        return viewModel.initSharePref().contains(ConstantVals().zipCodeKey)
    }

    override fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity :: class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (!checkPreviousUserPref())
            openSettingsActivity()
        //todo else zip code was founded
    }

    companion object {
        final val TAG = this.javaClass.simpleName
    }
}

