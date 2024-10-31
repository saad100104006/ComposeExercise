package com.exercise.compose.ui.products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ProductsRoute(viewModel: ProductViewModel = hiltViewModel(), onItemClick: (Int?) -> Unit) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ProductsScreen(uiState, onItemClick)
        CircularProgressDialog(uiState)
        CheckError(uiState)
    }
}

