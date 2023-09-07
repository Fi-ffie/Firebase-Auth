package com.example.firebaseauth.ui.theme.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseauth.data.productviewmodel
import com.example.firebaseauth.navigation.ROUTE_ADD_PRODUCT
import com.example.firebaseauth.navigation.ROUTE_REGISTER
import com.example.firebaseauth.navigation.ROUTE_UPDATE_PRODUCT
import com.example.firebaseauth.navigation.ROUTE_VIEW_PRODUCT
import com.example.firebaseauth.ui.theme.screen.login.LoginScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        var context= LocalContext.current
        var productdata= productviewmodel(navController, context)

        Text(text = "Welcome to Home page.",
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_PRODUCT)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add product.")
        }

        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_PRODUCT)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Update product.")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEW_PRODUCT)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "View product.")
        }
    }
}
@Preview
@Composable
fun Homepage(){
    HomeScreen(rememberNavController())
}