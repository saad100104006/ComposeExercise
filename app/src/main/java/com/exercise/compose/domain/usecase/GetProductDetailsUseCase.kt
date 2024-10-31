package com.exercise.compose.domain.usecase

import com.exercise.compose.data.mapper.toProductDetails
import com.exercise.compose.domain.repository.ProductRepository
import com.exercise.compose.domain.uimodel.ProductDetails
import com.exercise.compose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(id:Int?): Flow<Resource<ProductDetails>> = flow {
        try {
            emit(Resource.Loading)
            emit(Resource.Success(productRepository.getProductDetails(id).toProductDetails()))
        } catch (e: Exception) {
            emit(Resource.Error("Error !!"))
        }
    }
}