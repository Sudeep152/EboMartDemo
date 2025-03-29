package com.shashank.ebomart.remote.api

import com.shashank.ebomart.remote.response.EboMartProductItem
import retrofit2.http.GET

interface EboApi {

    @GET("alldocs.json")
    suspend fun getEboMovieList(): List<EboMartProductItem>
}