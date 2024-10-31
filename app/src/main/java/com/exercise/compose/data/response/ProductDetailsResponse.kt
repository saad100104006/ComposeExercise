package com.exercise.compose.data.response


import com.google.gson.annotations.SerializedName

data class ProductDetailsResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("images")
    val images: List<String>?
)