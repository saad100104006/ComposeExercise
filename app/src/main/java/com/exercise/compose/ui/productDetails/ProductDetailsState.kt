package com.exercise.compose.ui.productDetails

import com.exercise.compose.domain.uimodel.ProductDetails

data class ProductDetailsState(
    val isLoading: Boolean = false,
    val details: ProductDetails? = null,
    val error: String = ""
)