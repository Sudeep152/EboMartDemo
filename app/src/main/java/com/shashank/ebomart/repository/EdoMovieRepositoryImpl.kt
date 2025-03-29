package com.shashank.ebomart.repository

import com.shashank.ebomart.remote.api.EboApi
import com.shashank.ebomart.remote.response.EboMartProductItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EdoMovieRepositoryImpl @Inject constructor(val api: EboApi) : EdoMovieRepository {
    override suspend fun getMovie(): Flow<List<EboMartProductItem>> {
        return try {
            val response = api.getEboMovieList()
            val productList: List<EboMartProductItem> = response
            flow { emit(productList) }
        } catch (e: Exception) {
            flow { emit(emptyList()) }
        }
    }
}