package com.exercise.compose.domain.repository

import com.exercise.compose.data.response.ProductDetailsResponse
import com.exercise.compose.data.response.ProductResponse

interface ProductRepository {

    suspend fun getProducts(): ProductResponse

    suspend fun getProductDetails(id: Int?): ProductDetailsResponse
}