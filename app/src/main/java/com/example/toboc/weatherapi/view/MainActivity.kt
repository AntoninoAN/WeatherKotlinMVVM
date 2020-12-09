package com.example.toboc.weatherapi.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.example.toboc.weatherapi.R
import com.example.toboc.weatherapi.common.ConstantVals
import com.example.toboc.weatherapi.viewmodel.WeatherViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity(), ViewContract.LandingActivityContract {
    private lateinit var weatherViewModel : WeatherViewModel
//        ViewModelProvider.AndroidViewModelFactory(CustomApp()).create(ViewModel::class.java)

    private lateinit var toolbar: Toolbar

    override fun checkPreviousUserPref(): Boolean {
        Toast.makeText(
            this@MainActivity,
            weatherViewModel.initSharePref().contains(ConstantVals.zipCodeKey).toString(),
            Toast.LENGTH_SHORT
        ).show()
        return weatherViewModel.initSharePref().contains(ConstantVals.zipCodeKey)
    }

    override fun getPreviousUserPref() {
        TODO("Not yet implemented")
    }

    override fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    override fun implementBinding() {
        toolbar = findViewById(R.id.toolbar_weather)
        setSupportActionBar(toolbar)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        implementBinding()
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        if (!checkPreviousUserPref())
            openSettingsActivity()
        //todo else zip code was founded
    }

    override fun onOptionsItemSelected(item: MenuItem)= when(item.itemId){
        R.id.settings_options->{
            //todo open SEttings Activity
            Log.i(TAG, "onOptionsItemSelected True")
            true
        }
        else->{
            super.onOptionsItemSelected(item)
            Log.d(TAG, "onOptionsItemSelected: No Item Id Menu Recongnized")
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}

