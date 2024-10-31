package com.exercise.compose.ui.productDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.exercise.compose.ui.products.CheckError
import com.exercise.compose.ui.products.ProductState
import com.exercise.compose.ui.products.ProductsScreen
import com.exercise.compose.ui.theme.Black

@Composable
fun ProductDetailsRoute(
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ProductDetailsScreen(modifier, uiState.details, onBackClick)
        CircularProgressDialog(uiState)
    }
}

@Composable
fun CircularProgressDialog(uiState: ProductDetailsState) {
    if (uiState.isLoading) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Black
            )
        }
    }
}
