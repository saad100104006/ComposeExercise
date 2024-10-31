package com.exercise.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.exercise.compose.ui.productDetails.ProductDetailsRoute
import com.exercise.compose.ui.products.ProductsRoute
import com.exercise.compose.utils.Constants.PRODUCT_ID

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Products.route) {
        composable(Screen.Products.route) {
            ProductsRoute(onItemClick = { id ->
                navController.navigate(route = Screen.ProductDetails.route + "/${id}")
            })
        }
        composable(Screen.ProductDetails.route + "/{" + PRODUCT_ID + "}") {
            ProductDetailsRoute(onBackClick = { navController.navigateUp() })
        }
    }
}