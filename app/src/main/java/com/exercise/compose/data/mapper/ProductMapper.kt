package com.exercise.compose.data.mapper

import com.exercise.compose.data.response.ProductDetailsResponse
import com.exercise.compose.data.response.ProductResponseItem
import com.exercise.compose.domain.uimodel.ProductDetails
import com.exercise.compose.domain.uimodel.ProductUiModel


fun ProductResponseItem.toProductUiModel() = ProductUiModel(
    id = id ?: -1,
    title = title.orEmpty(),
    thumbnail = thumbnail.orEmpty(),
    brand = brand.orEmpty(),
    price = price?:0.0
)

fun ProductDetailsResponse.toProductDetails() = ProductDetails(
    id = id ?: -1,
    title = title.orEmpty(),
    description = description.orEmpty(),
    image = images?.first().orEmpty()
)



