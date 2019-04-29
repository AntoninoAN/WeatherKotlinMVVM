package com.example.toboc.weatherapi

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.toboc.weatherapi.Common.CustomApp
import com.example.toboc.weatherapi.VIew.ViewContract
import com.example.toboc.weatherapi.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_settings.*

/**
 * Activity for Zip Code interaction
 * @sample First time run, ask for values
 * @sample Update values, first read and then update.
 */
class SettingsActivity : AppCompatActivity(), ViewContract.SettingsActivityContract {
    override fun readPreviousSP() {
        //todo get value from viewmodel and update the corresponding field

    }

    override fun checkIntent(intent: Intent?) {
        intent?.action.apply {
            readPreviousSP()
        }
    }

    override fun updateSP(zipCode: String, optional: Boolean) {
        viewModel.saveUserPref(zipCode,optional)
    }

    val viewModel by lazy{
         ViewModelProvider.AndroidViewModelFactory(CustomApp).create(ViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        print(TAG)
        var zipCode : String = til_zip_code.editText?.text.toString()
        var optional = optional_user.isChecked

        checkIntent(intent)

        btn_save_zip_code.setOnClickListener { _ -> updateSP(zipCode, optional) }
    }

    //todo zip code validation?
    //todo read previous saved value
    companion object {
        final val TAG = this.javaClass.simpleName
    }
}
