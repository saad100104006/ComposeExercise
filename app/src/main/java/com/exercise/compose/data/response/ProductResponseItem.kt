package com.exercise.compose.data.response


import com.google.gson.annotations.SerializedName

data class ProductResponseItem(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("thumbnail")
    val thumbnail: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("price")
    val price: Double?
)

data class ProductResponse(
    @SerializedName("products")
    val products:  ArrayList<ProductResponseItem>
)
