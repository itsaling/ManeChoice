package com.example.manechoiceapp

import com.google.gson.annotations.SerializedName

data class products(
    @SerializedName("id")
    val id: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("product_description")
    val productInfo: String
    )