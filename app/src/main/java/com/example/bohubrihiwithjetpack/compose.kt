package com.example.bohubrihiwithjetpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun composable() {
    val main = MainActivity().getRegionsHttp()
    Column() {
        main



    }
}