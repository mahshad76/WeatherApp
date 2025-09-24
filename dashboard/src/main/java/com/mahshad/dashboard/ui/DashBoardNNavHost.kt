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
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahshad.authentication.R
import com.mahshad.dashboard.common.navigateToCurrentWeather
import com.mahshad.dashboard.common.navigateToForecast
import com.mahshad.dashboard.ui.DashBoardViewModel
import com.mahshad.dashboard.ui.currentweather.CurrentWeather
import com.mahshad.dashboard.ui.weatherforecast.WeatherForecast
import com.mahshad.systemdesign.BottomAppBar
import com.mahshad.systemdesign.BottomNavigationItem
import kotlinx.serialization.Serializable

@Serializable
data object DashBoardRoute

@Composable
fun DashBoardNavHost(
    viewModel: DashBoardViewModel = hiltViewModel()
) {
    val stateValue by viewModel.uiStateFlow.collectAsStateWithLifecycle()
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                bottomNavigationItems = listOf(
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
                selectedItemIndex = stateValue,
                onItemSelected = { selectedItemIndex ->
                    viewModel.updateSelectedItem(selectedItemIndex)
                },
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = CurrentWeather::class
        ) {
            composable<CurrentWeather> {
                CurrentWeather({ navController.navigateToForecast() })
            }
            composable<WeatherForecast> {
                WeatherForecast({ navController.navigateToCurrentWeather() })
            }
        }
    }
}

