package com.example.chatapp



import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.nav.Action
import com.example.chatapp.nav.Destination.AuthenticationOption
import com.example.chatapp.nav.Destination.Home
import com.example.chatapp.nav.Destination.Login
import com.example.chatapp.nav.Destination.Register
import com.google.firebase.auth.FirebaseAuth

import com.example.chatapp.ui.theme.ChatAppTheme
import com.example.chatapp.view.AuthenticationView
import com.example.chatapp.view.home.HomeView
import com.example.chatapp.view.login.LoginView
import com.example.chatapp.view.register.RegisterView

@Composable
fun NavComposeApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    ChatAppTheme {
        NavHost(
            navController = navController,
            startDestination =
            if (FirebaseAuth.getInstance().currentUser != null)
                Home
            else
                AuthenticationOption
        ) {
            composable(AuthenticationOption) {
                AuthenticationView(
                    register = actions.register,
                    login = actions.login
                )
            }
            composable(Register) {
                RegisterView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Login) {
                LoginView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Home) {
                HomeView()
            }
        }
    }
}