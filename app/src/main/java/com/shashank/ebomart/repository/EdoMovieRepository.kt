package com.shashank.ebomart.repository

import com.shashank.ebomart.remote.response.EboMartProductItem
import com.shashank.ebomart.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface EdoMovieRepository {

    suspend fun getMovie(): Flow<List<EboMartProductItem>>
}