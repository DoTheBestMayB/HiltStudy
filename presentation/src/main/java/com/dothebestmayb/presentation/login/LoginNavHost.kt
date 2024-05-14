package com.dothebestmayb.presentation.login

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute.WelcomeScreen.name,
    ) {
        composable(
            route = LoginRoute.WelcomeScreen.name
        ) {
            WelcomeScreen(
                onNavigateToLoginScreen = {
                    navController.navigate(
                        route = LoginRoute.LoginScreen.name
                    )
                },
            )
        }

        composable(route = LoginRoute.LoginScreen.name) {
            LoginScreen(
                id = "volums",
                password = "asdf",
                onIdChange = {},
                onPasswordChange = {}
            ) {

            }
        }

        composable(route = LoginRoute.SignUpScreen.name) {
            SignUpScreen(
                id = "cubilia",
                username = "Elvis Ingram",
                password1 = "fabellas",
                password2 = "postulant",
                onIdChange = {},
                onUsernameChange = {},
                onPassword1Change = {},
                onPassword2Change = {}
            ) {

            }
        }
    }
}