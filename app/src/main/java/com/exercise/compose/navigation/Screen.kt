package com.exercise.compose.navigation

sealed class Screen(val route: String){
    object Products : Screen("products_list_screen")

    object ProductDetails : Screen("product_details_screen")
}
