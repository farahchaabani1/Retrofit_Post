package com.example.retrofitapi.model

import com.google.gson.annotations.SerializedName

data class Product(

	@field:SerializedName("images")
	val images: String? = "",

	@field:SerializedName("prix")
	val prix: String = "",

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("nom")
	val nom: String? = null
)
