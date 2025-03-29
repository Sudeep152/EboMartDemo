package com.shashank.ebomart.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.ebomart.remote.response.EboMartProductItem
import com.shashank.ebomart.repository.EdoMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EboMovieViewModel @Inject constructor(private val repository: EdoMovieRepository) :
    ViewModel() {
    private var movieResponse: MutableStateFlow<List<EboMartProductItem>> =
        MutableStateFlow(value = emptyList())
    val movieList: MutableStateFlow<List<EboMartProductItem>> get() = movieResponse


    init {
        getMovie()
    }

    fun getMovie() {
        viewModelScope.launch {
            repository.getMovie().collect { response ->
                movieResponse.value = response
                Log.d("EboMovieViewModel", "Movie list updated: ${movieResponse.value}")
            }
        }
    }
}