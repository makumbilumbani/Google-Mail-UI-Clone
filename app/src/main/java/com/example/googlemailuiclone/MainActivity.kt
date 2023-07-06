package com.example.googlemailuiclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.contentValuesOf
import com.example.googlemailuiclone.components.GMailFab
import com.example.googlemailuiclone.components.GmailDrawerMenu
import com.example.googlemailuiclone.components.HomeAppBar
import com.example.googlemailuiclone.components.HomeBottomMenu
import com.example.googlemailuiclone.components.MailList
import com.example.googlemailuiclone.ui.theme.GoogleMailUICloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMailUICloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GmailApp(){
    var scaffoldState = rememberScaffoldState()
    var coroutineScope =  rememberCoroutineScope()
    var scrollState =  rememberScrollState()
    val openDialog = remember{
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState
        ,topBar = {HomeAppBar(scaffoldState,coroutineScope,openDialog)},
        drawerContent = {
        GmailDrawerMenu(scrollState)
    },
    bottomBar = {
        HomeBottomMenu()
    },
    floatingActionButton = {
        GMailFab(scrollState)
    }
        ) {
        MailList(paddingValues = it, scrollState)
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    GoogleMailUICloneTheme{
        Surface{
            GmailApp()
        }
    }
}