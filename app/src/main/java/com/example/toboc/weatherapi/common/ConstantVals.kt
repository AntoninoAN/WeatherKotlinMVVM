package com.example.toboc.weatherapi.common

import com.example.toboc.weatherapi.R

object ConstantVals {
    /**
     * Having a constant value for SP
     */
    val sharedPrefFile = CustomApp.instance.getString(R.string.common_sp_file)
    val zipCodeKey = CustomApp.instance.getString(R.string.sp_zip_code_key)
    val optionKey = CustomApp.instance.getString(R.string.sp_optional_key)
    val optionMetrics = CustomApp.instance.getString(R.string.sp_metrics_key)
}