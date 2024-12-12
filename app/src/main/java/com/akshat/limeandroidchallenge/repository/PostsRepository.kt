package com.akshat.limeandroidchallenge.repository

import com.akshat.limeandroidchallenge.data.Resource
import com.akshat.limeandroidchallenge.model.Posts
import com.akshat.limeandroidchallenge.network.PostsAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostsRepository @Inject constructor(private val apiService: PostsAPI) {

    val posts: Flow<Resource<Posts>> = flow {
        val posts = apiService.getPostData()
        emit(Resource.Success(posts))
    }
}