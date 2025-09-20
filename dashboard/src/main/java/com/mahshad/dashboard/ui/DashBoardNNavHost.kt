import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import com.mahshad.authentication.R
import com.mahshad.dashboard.ui.DashBoardViewModel
import com.mahshad.systemdesign.BottomAppBar
import com.mahshad.systemdesign.BottomNavigationItem

@Composable
fun DashBoardNavHost(
    viewModel: DashBoardViewModel = hiltViewModel()
) {
    val stateValue by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                listOf(
                    BottomNavigationItem(
                        "Current weather",
                        ImageVector.vectorResource(id = R.drawable.weather_svgrepo_filled),
                        ImageVector.vectorResource(id = R.drawable.weather_svgrepo_com)
                    ),
                    BottomNavigationItem(
                        "Weather forecast",
                        ImageVector.vectorResource(id = R.drawable.calender_svgrepo_filled),
                        ImageVector.vectorResource(id = R.drawable.calender_svgrepo_com)
                    )
                ),
                stateValue,
                { selectedItemIndex ->
                    viewModel.updateSelectedItem(selectedItemIndex)
                }
            )
        }
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

