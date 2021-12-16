package test.cs.composedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import test.cs.composedex.ui.theme.ComposeDexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "dex_list_screen"
                ) {
                    composable("dex_list_screen") {

                    }
                    composable(
                        "dex_detail_screen/{dominantColor}/{pokeName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokeName"){
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            it.arguments?.getInt("dominantColor")?.let { Color(it) } ?: Color.White
                        }
                        val pokeName = remember {
                            it.arguments?.getString("pokeName")
                        }
                    }
                }
            }
        }
    }
}