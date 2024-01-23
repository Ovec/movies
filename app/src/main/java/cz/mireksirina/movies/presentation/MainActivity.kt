package cz.mireksirina.movies.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import cz.mireksirina.movies.presentation.nav.NavGraph
import cz.mireksirina.movies.presentation.nav.Route
import cz.mireksirina.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MoviesTheme(dynamicColor = false) {
//                val isSystemInDarkMode = isSystemInDarkTheme()
//                val systemUiColor = rememberSystemUiController()
//                SideEffect {
//                    systemUiColor.setSystemBarsColor(
//                        color = Color.Transparent,
//                        darkIcons = !isSystemInDarkMode
//                    )
//                }
                //Add fillMaxSize()
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
                    NavGraph(startDestination = Route.PopularScreen.route)
                }
            }
        }

//
//        setContent {
//            MoviesTheme(dynamicColor = false) {
//                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
//                    // NavGraph(startDestination = Route.PopularScreen.route)
//                    Greeting("Android")
//                }
//            }
//        }
//

//        setContent {
//            MoviesTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(vertical = 50.dp, horizontal = 10.dp),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    NavGraph(startDestination = Route.PopularScreen.route)
//                    Greeting("Android")
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesTheme {
        Greeting("Android")
    }
}