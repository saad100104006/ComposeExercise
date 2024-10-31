package com.exercise.compose.data.remote

import com.exercise.compose.data.response.ProductDetailsResponse
import com.exercise.compose.data.response.ProductResponse
import com.exercise.compose.utils.Constants.PRODUCTS
import com.exercise.compose.utils.Constants.PRODUCT_DETAILS
import com.exercise.compose.utils.Constants.PRODUCT_ID
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET(PRODUCTS)
    suspend fun getProducts(): ProductResponse

    @GET(PRODUCT_DETAILS)
    suspend fun getProductDetails(@Path(PRODUCT_ID ) id: Int?): ProductDetailsResponse

}