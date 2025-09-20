import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

@Composable
fun DashBoardNavHost() {
    Scaffold(
        topBar = {},
        bottomBar = {}
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = TODO(),
            startDestination = TODO(),
            contentAlignment = TODO(),
            route = TODO(),
            typeMap = TODO(),
            enterTransition = TODO(),
            exitTransition = TODO(),
            popEnterTransition = TODO(),
            popExitTransition = TODO(),
            sizeTransform = TODO()
        ) { }
    }
}

