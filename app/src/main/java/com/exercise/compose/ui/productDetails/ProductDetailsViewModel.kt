package com.exercise.compose.ui.productDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.compose.domain.usecase.GetProductDetailsUseCase
import com.exercise.compose.utils.Constants.PRODUCT_ID
import com.exercise.compose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductDetailsState())
    val uiState: StateFlow<ProductDetailsState> = _uiState.asStateFlow()

    init {
        savedStateHandle.get<String>(PRODUCT_ID)?.let {
            getProductDetails(it.toInt())
        }
    }

    private fun getProductDetails(id: Int?) {
            getProductDetailsUseCase.invoke(id).onEach { result ->
                when (result) {
                    Resource.Loading -> _uiState.value = ProductDetailsState(isLoading = true)
                    is Resource.Success -> {
                        result.data.let {
                            _uiState.value = ProductDetailsState(details = it)
                        }
                    }
                    is Resource.Error -> _uiState.value = ProductDetailsState(error = result.errorMessage)
                }
            }.launchIn(viewModelScope)
    }
}