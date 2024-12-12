package com.akshat.limeandroidchallenge.network

import com.akshat.limeandroidchallenge.model.Posts
import retrofit2.http.GET

interface PostsAPI {
    @GET(value = "r/travel/top.json")
    suspend fun getPostData(): Posts
}