package com.example.firebaseauth.navigation

import android.view.ViewManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.ui.theme.screen.about.AboutScreen
import com.example.firebaseauth.ui.theme.screen.home.HomeScreen
import com.example.firebaseauth.ui.theme.screen.login.LoginScreen
import com.example.firebaseauth.ui.theme.screen.product.AddProductScreen
import com.example.firebaseauth.ui.theme.screen.product.UpdateProductScreen
import com.example.firebaseauth.ui.theme.screen.product.ViewProductScreen
import com.example.firebaseauth.ui.theme.screen.product.ViewProductScreen
import com.example.firebaseauth.ui.theme.screen.register.RegisterScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),
               startDestination:String= ROUTE_LOGIN) {
    NavHost(navController = navController, modifier=modifier, startDestination = startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
            AddProductScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductScreen(navController,passedData.arguments?.getString("id")!!)
        }
    }
}