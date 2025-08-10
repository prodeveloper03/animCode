package com.code.quizzo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.code.quizzo.ui.ClaimTheThrone
import com.code.quizzo.ui.FinalVictory
import com.code.quizzo.ui.StepUpAndScore


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.StepUpAndScore.route
    ) {
        composable(Screen.StepUpAndScore.route) {
            StepUpAndScore(
                onNextClick = {
                    navController.navigate(Screen.ClaimTheThrone.route)
                }
            )
        }

        composable(Screen.ClaimTheThrone.route) {
            ClaimTheThrone(
                onNextClick = {
                    navController.navigate(Screen.FinalVictory.route)
                }
            )
        }

        composable(Screen.FinalVictory.route) {
            FinalVictory(onFinishClick = {

            })
        }
    }
}