package com.code.quizzo.navigation

sealed class Screen(val route: String) {
    object StepUpAndScore : Screen("step_up_and_score")
    object ClaimTheThrone : Screen("claim_the_throne")
    object FinalVictory : Screen("final_victory")
}
