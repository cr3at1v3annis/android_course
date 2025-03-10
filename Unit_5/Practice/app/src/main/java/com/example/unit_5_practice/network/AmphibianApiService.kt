package com.example.unit_5_practice.network

import com.example.unit_5_practice.model.AmphibianPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getPhotos(): List<AmphibianPhoto>
}