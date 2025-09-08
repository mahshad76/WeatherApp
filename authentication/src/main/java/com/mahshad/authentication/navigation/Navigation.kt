package com.mahshad.authentication.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mahshad.authentication.signup.SignUpRoute
import kotlinx.serialization.Serializable

@Serializable
data object MainRoute

@Serializable
data object AuthRoute

@Serializable
data object SignUpRoute

@Serializable
data object UsernameRoute

// Extensions for navigation
val NavController.onNavigateToLogIn: () -> Unit
    get() = {} // This would be implemented to navigate to the login screen.

val NavController.onNavigateToSignUp: () -> Unit
    get() = { this.navigate(SignUpRoute) }

val NavController.onSuccessLogIn: () -> Unit
    get() = { this.navigate(MainRoute) } // Corrected to navigate to a valid route.

/**
 * Defines the authentication navigation graph.
 * The `route` is set to `AuthRoute::class` so it can be referenced
 * from the top-level `NavHost`.
 */
fun NavGraphBuilder.authNavGraph(
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogIn: () -> Unit,
    onSuccessLogIn: () -> Unit
) {
    navigation<AuthRoute>(startDestination = UsernameRoute::class) {
        composable<UsernameRoute>{
            // Your composable screen content for the username part of the flow.
            Text("Hello, this is the Auth graph start screen.")
        }
    }
}

/**
 * Defines the main app navigation graph.
 * This graph would contain all the screens for the logged-in user.
 */



//    navigation<AuthRoute>(
//        startDestination = LogInRoute,
//    ) {
//        // Call the individual nav graphs to add their composables
//        loginNavGraph(
//            onNavigateToSignUp = onNavigateToSignUp,
//            onSuccessLogIn = onSuccessLogIn
//        )
//        signUpNavGraph(
//            onNavigateToLogIn = { /* Convert lambda with arguments to a simple one if needed */ }
//        )
//    }
