package com.akshat.limeandroidchallenge.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshat.limeandroidchallenge.data.Resource
import com.akshat.limeandroidchallenge.model.Posts
import com.akshat.limeandroidchallenge.repository.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val postsRepository: PostsRepository) :
    ViewModel() {
    private val _posts = MutableStateFlow<Resource<Posts>>(Resource.Loading())
    val posts: StateFlow<Resource<Posts>> = _posts.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            postsRepository.posts.catch {
                _posts.value = Resource.Error(it.message)
            }.collect {
                _posts.value = Resource.Success(it.data!!)
            }
        }
    }

}