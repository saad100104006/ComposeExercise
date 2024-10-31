package com.exercise.compose.ui.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.exercise.compose.ui.theme.Black
import com.exercise.compose.ui.theme.Teal200
import com.exercise.compose.utils.ComposeText
import com.exercise.compose.utils.ErrorText

@Composable
fun ProductsScreen(products: ProductState, onItemClick: (Int?) -> Unit) {
    Column {
        ComposeText(
            textAlign = TextAlign.Center,
            text = "All Products",
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(
                    start = 12.dp, top = 12.dp, bottom = 12.dp
                ),
            color = Black
        )
        LazyColumn(contentPadding = PaddingValues(start = 12.dp, end = 12.dp)) {
            items(products.products) { userItem ->
                ProductItem(productUiModel = userItem) { id ->
                    onItemClick.invoke(id)
                }
            }
        }
    }
}

@Composable
fun CircularProgressDialog(uiState: ProductState) {
    if (uiState.isLoading) {
        Box {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Black
            )
        }
    }
}

@Composable
fun CheckError(uiState: ProductState) {
    Box {
        if (uiState.error.isNotBlank()) {
            ErrorText(uiState.error, Modifier.align(Alignment.Center))
        }
    }
}