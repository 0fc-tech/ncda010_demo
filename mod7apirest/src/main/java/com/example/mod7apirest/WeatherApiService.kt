package com.example.mod7apirest

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude : Double,
        @Query("longitude") longitude : Double,
        @Query("current") current: String,
        @Query("hourly") hourly: String
    ) : WeatherResponse
}