package com.exercise.compose.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.compose.domain.usecase.GetProductsUseCase
import com.exercise.compose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase): ViewModel() {

    private val _uiState = MutableStateFlow(ProductState())
    val uiState: StateFlow<ProductState> = _uiState.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsUseCase.products.onEach { result ->
            when (result) {
                Resource.Loading -> _uiState.value = ProductState(isLoading = true)
                is Resource.Success -> {
                    result.data.let {
                        _uiState.value = ProductState(products = it)
                    }
                }
                is Resource.Error -> _uiState.value = ProductState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}