package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import snackbarkmp.composeapp.generated.resources.Res
import snackbarkmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {

        val snackBarHostState = remember { SnackbarHostState() }
        val localCoroutineScope = rememberCoroutineScope()
        val greeting = remember { Greeting().greet() }
        Scaffold(snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    localCoroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            greeting
                        )
                    }
                }) {
                    Text("Click me!")
                }
            }
        }
    }
}