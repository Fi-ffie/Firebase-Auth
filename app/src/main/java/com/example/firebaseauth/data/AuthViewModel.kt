package com.example.firebaseauth.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.firebaseauth.navigation.ROUTE_HOME
import com.example.firebaseauth.navigation.ROUTE_LOGIN
import com.example.firebaseauth.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.TotpMultiFactorInfo
import java.util.function.ToIntBiFunction

class AuthViewModel(var navController:NavHostController,var context:Context){
    var mAuth:FirebaseAuth

    init {
        mAuth= FirebaseAuth.getInstance()
    }
    fun signup(email:String, pass:String, confpass:String){

        if (email.isBlank() ||pass.isBlank() ||confpass.isBlank()){
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Passwords do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_HOME)
                }else{
                    Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                    navController.navigate(ROUTE_LOGIN)
                }
            }
        }
    }
    fun login(email:String, pass: String){

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(context,"Successfully logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//                navController.navigate(ROUTE_REGISTER)To take you to a different page.
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }
}