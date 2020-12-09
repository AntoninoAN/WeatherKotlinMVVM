package com.example.toboc.weatherapi.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.toboc.weatherapi.R
import com.example.toboc.weatherapi.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_settings.*

/**
 * Activity for Zip Code interaction
 * @sample First time run, ask for values
 * @sample Update values, first read and then update.
 */
class SettingsActivity : AppCompatActivity(), ViewContract.SettingsActivityContract {

    override fun updateSP(zipCode: String, optional: Boolean, metrics: Boolean) {
        println(TAG + "udpateSP")
        weatherViewModel.saveUserPref(zipCode,optional, metrics)
        finish()
    }

    lateinit var weatherViewModel : WeatherViewModel
//         ViewModelProvider.AndroidViewModelFactory(CustomApp()).create(ViewModel::class.java)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        print(TAG)
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        var zipCode : String = til_zip_code.editText?.text.toString()
        var optional = optional_user.isChecked
        var imperial = chbx_imperial.isChecked
        til_zip_code.editText!!.setOnFocusChangeListener { _, hasFocus ->
            run {
                if (!hasFocus)
                    btn_save_zip_code.isEnabled = til_zip_code.editText!!.isEnabled
            }
        }

        btn_save_zip_code.setOnClickListener { _ -> updateSP(zipCode, optional, imperial) }
    }

    //todo zip code validation?
    //todo read previous saved value
    companion object {
        final val TAG = SettingsActivity::class.java.simpleName
    }
}
