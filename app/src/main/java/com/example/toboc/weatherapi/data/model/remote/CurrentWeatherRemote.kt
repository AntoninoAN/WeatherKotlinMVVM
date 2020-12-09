package com.example.toboc.weatherapi.data.model.remote

data class CurrentWeatherRemote(val coord: CurrentCoordRemote, val name: String, val main: CurrentMainRemote)

data class CurrentCoordRemote(val lon: Float, val lat: Float)

data class CurrentMainRemote(val temp: Float, val feels_like: Float)

data class ForecastRemote(val hourly: List<ForecastHourly>)

data class ForecastHourly(val temp: Float, val feels_like: Float)

//units standard, metric, imperial
