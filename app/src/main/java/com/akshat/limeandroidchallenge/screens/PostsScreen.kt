package com.akshat.limeandroidchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.akshat.limeandroidchallenge.components.LimeAndroidAppBar
import com.akshat.limeandroidchallenge.data.Resource
import com.akshat.limeandroidchallenge.model.PostItems

@Composable
fun PostsScreen(
    navController: NavController, postsViewModel: PostsViewModel = hiltViewModel()
) {
        Scaffold(topBar = {
            LimeAndroidAppBar(
                navController = navController,
                elevation = 7.dp
            )
        }) { it ->
            Surface(modifier = Modifier.padding(top = it.calculateTopPadding())) {
                val posts by postsViewModel.posts.collectAsStateWithLifecycle()

                when (posts) {
                    is Resource.Loading -> {
                        Text(text = "Loading...")
                    }

                    is Resource.Success -> {
                        LazyColumn {
                            posts.data?.data?.children?.let { it ->
                                items(items = it) { children ->
                                    if (children.data.thumbnail != "self") {
                                        PostRow(children.data)
                                    }
                                }
                            }
                        }
                    }

                    is Resource.Error -> {
                        Text(text = posts.message.toString())
                    }

                }
            }
        }
}

@Composable
fun PostRow(
    data: PostItems
) {

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {},
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        colors = CardColors(
            Color.White, Color.Black, Color.White, Color.White
        ),
        elevation = CardDefaults.cardElevation(6.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberImagePainter(data.thumbnail),
                contentDescription = "icon image",
                modifier = Modifier.size(width = 450.dp, height = 200.dp)
                    .padding(top = 4.dp),
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .padding(start = 6.dp, top = 10.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2
                )
                Text(
                    text = "Author : ${data.author}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }

    }


}