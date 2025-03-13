package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//builder --flat-3M -5lac car,2lac-marble-3lacs

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))

    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
   suspend fun getPhotos(): List<MarsPhoto>

}

//object -- singleton design patter
//by = delegation pattern
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
