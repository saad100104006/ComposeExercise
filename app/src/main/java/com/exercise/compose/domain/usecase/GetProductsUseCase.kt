package com.exercise.compose.domain.usecase

import com.exercise.compose.data.mapper.toProductUiModel
import com.exercise.compose.domain.repository.ProductRepository
import com.exercise.compose.domain.uimodel.ProductUiModel
import com.exercise.compose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    val products: Flow<Resource<List<ProductUiModel>>> = flow {
        try {
            emit(Resource.Loading)
            emit(Resource.Success(productRepository.getProducts().products.map { it.toProductUiModel() }))
        } catch (e: Exception) {
            emit(Resource.Error("Error !!"))
        }
    }
}