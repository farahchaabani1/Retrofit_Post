package com.example.retrofitapi.network

import com.example.retrofitapi.model.Product
import com.example.retrofitapi.model.ResponseProduct
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private var BASE_URL="http://10.0.2.2:8080/"
private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()) // For JSON parsing
    .baseUrl(BASE_URL)
    .build()

//Interface containing API
interface ApiService{
    @POST("create")
    suspend fun  createProduct(@Body product: Product): ResponseProduct
}

object ProductApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }}