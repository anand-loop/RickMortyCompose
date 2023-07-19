package com.anandj.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anandj.rickmorty.model.Character
import com.anandj.rickmorty.model.Episode
import com.anandj.rickmorty.model.Location
import com.anandj.rickmorty.screen.CharactersViewModel
import com.anandj.rickmorty.screen.EpisodesViewModel
import com.anandj.rickmorty.screen.LocationsViewModel
import com.anandj.rickmorty.screen.SimpleStatefulList
import com.anandj.rickmorty.ui.BottomNavBar
import com.anandj.rickmorty.ui.CharacterView
import com.anandj.rickmorty.ui.DebugDrawer
import com.anandj.rickmorty.ui.EpisodeView
import com.anandj.rickmorty.ui.LocationView
import com.anandj.rickmorty.ui.NavigationItem
import com.anandj.rickmorty.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val navItems = listOf(
        NavigationItem(title = R.string.screen_title_characters, icon = R.drawable.ic_person, "characters_screen"),
        NavigationItem(title = R.string.screen_title_locations, icon = R.drawable.ic_location, "locations_screen"),
        NavigationItem(title = R.string.screen_title_episodes, icon = R.drawable.ic_episode, "episodes_screen"),
    )

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    RickMortyApp(navController, navItems)
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun RickMortyApp(navController: NavHostController, navItems: List<NavigationItem>) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DebugDrawer() },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
                },
                bottomBar = {
                    BottomNavBar(items = navItems, navController = navController)
                },
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = "characters_screen",
                    modifier = Modifier.padding(padding),
                ) {
                    composable("characters_screen") {
                        val viewModel: CharactersViewModel = viewModel()
                        SimpleStatefulList<Character>(viewModel) {
                            CharacterView(character = it)
                        }
                    }
                    composable("locations_screen") {
                        val viewModel: LocationsViewModel = viewModel()
                        SimpleStatefulList<Location>(viewModel) {
                            LocationView(location = it)
                        }
                    }
                    composable("episodes_screen") {
                        val viewModel: EpisodesViewModel = viewModel()
                        SimpleStatefulList<Episode>(viewModel) {
                            EpisodeView(episode = it)
                        }
                    }
                }
            }
        },
    )
}
