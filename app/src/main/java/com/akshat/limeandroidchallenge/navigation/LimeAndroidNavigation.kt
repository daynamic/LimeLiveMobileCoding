package com.akshat.limeandroidchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akshat.limeandroidchallenge.screens.PostsScreen
import com.akshat.limeandroidchallenge.screens.PostsViewModel

@Composable
fun LimeChallengeNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "posts"
    ) {

        composable("posts") {
            val postsViewModel = hiltViewModel<PostsViewModel>()
            PostsScreen(navController = navController, postsViewModel = postsViewModel)
        }


    }


}