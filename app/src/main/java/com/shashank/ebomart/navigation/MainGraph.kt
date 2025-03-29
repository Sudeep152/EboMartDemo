package com.shashank.ebomart.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.shashank.ebomart.routes.EBOAppRoutes
import com.shashank.ebomart.screen.EboHomeScreen
import com.shashank.ebomart.screen.ProductDetailScreen

@Composable
fun MainGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = EBOAppRoutes.HomeScreen) {
        composable<EBOAppRoutes.HomeScreen> {
            EboHomeScreen(modifier = modifier, navigate ={
                navController.navigate(EBOAppRoutes.DetailScreen(it))
            } )
        }
        composable<EBOAppRoutes.DetailScreen> {
            val data = it.toRoute<EBOAppRoutes.DetailScreen>()
            ProductDetailScreen(name = data.id)
            BackHandler {
                navController.popBackStack()
            }
        }
    }

}