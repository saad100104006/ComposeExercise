package com.exercise.compose.ui.products

import com.exercise.compose.domain.uimodel.ProductUiModel

data class ProductState(
    val isLoading: Boolean = false,
    val products: List<ProductUiModel> = emptyList(),
    val error: String = ""
)