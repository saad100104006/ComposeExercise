package com.exercise.compose.data.repository

import com.exercise.compose.data.remote.Service
import com.exercise.compose.data.response.ProductDetailsResponse
import com.exercise.compose.data.response.ProductResponse
import com.exercise.compose.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val service: Service): ProductRepository {

    override suspend fun getProducts(): ProductResponse = service.getProducts()

    override suspend fun getProductDetails(id: Int?): ProductDetailsResponse = service.getProductDetails(id)
}