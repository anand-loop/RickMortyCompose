package com.anandj.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import com.anandj.rickmorty.ui.EpisodeView
import com.anandj.rickmorty.ui.LocationView
import com.anandj.rickmorty.ui.NavigationItem
import com.anandj.rickmorty.ui.theme.RickMortyTheme

class MainActivity : ComponentActivity() {
    private val navItems = listOf(
        NavigationItem(title = R.string.screen_title_characters, icon = R.drawable.ic_person, "characters_screen"),
        NavigationItem(title = R.string.screen_title_locations, icon = R.drawable.ic_location, "locations_screen"),
        NavigationItem(title = R.string.screen_title_episodes, icon = R.drawable.ic_episode, "episodes_screen")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    RickMortyApp(navController, navItems)
                }
            }
        }
    }
}

@Composable
fun RickMortyApp(navController: NavHostController, navItems: List<NavigationItem>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
        },
        bottomBar = {
            BottomNavBar(items = navItems, navController = navController)
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "characters_screen",
            modifier = Modifier.padding(padding)
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
}
