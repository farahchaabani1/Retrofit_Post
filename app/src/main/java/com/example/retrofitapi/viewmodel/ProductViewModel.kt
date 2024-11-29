package com.example.retrofitapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapi.network.ProductApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ProductViewModel: ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var prodUiState = mutableStateOf<ResponseProduct?>(null)


    fun createProduct(product: Product) {
        viewModelScope.launch {
            try {
                val result = ProductApi.retrofitService.createProduct(product)
                prodUiState.value=result
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}