package com.andreasgift.kmmnotes.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreasgift.kmmnotes.DatabaseDriverFactory
import com.andreasgift.kmmnotes.KmmSdk
import com.andreasgift.kmmnotes.android.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    lateinit var sdk: KmmSdk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sdk = KmmSdk(DatabaseDriverFactory(applicationContext))

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    KmmNotesNavHost(sdk = sdk)
                }
            }
        }
    }
}

@Composable
fun KmmNotesNavHost(
    sdk: KmmSdk,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                notes = sdk.getAllNotes(),
                onNavigateToAdd = { navController.navigate("add") },
            )
        }
        composable("add") {
            AddScreen(
                saveNote = { note ->
                    sdk.insertNote(note.title, note.body)
                    navController.navigate("home") { popUpTo("home") { inclusive = true } }
                })
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        HomeScreen(notes = arrayListOf(), onNavigateToAdd = {})
    }
}
