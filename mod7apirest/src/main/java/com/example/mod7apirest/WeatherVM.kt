package com.example.mod7apirest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherVM : ViewModel() {
    private val _weather = MutableStateFlow<HourlyData?>(null)
    val weather = _weather.asStateFlow()

    init {fetchWeather()}

    fun fetchWeather(): Unit {
        viewModelScope.launch(Dispatchers.IO) {
            _weather.update {
                RetrofitClient.weatherApiService.getWeatherData(
                    latitude = 46.316380,
                    longitude = -0.471264,
                    current = "temperature_2m,wind_speed_10m",
                    hourly = "temperature_2m"
                ).hourly
            }
        }
    }
}