package com.shashank.ebomart.remote.response


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable





@Serializable
data class EboMartProductItem(
    @SerializedName("actors")
    val actors: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("date_released")
    val dateReleased: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("director")
    val director: String? = null,
    @SerializedName("image_landscape")
    val imageLandscape: String? = null,
    @SerializedName("image_portrait")
    val imagePortrait: String? = null,
    @SerializedName("imdb")
    val imdb: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("netflixid")
    val netflixid: String? = null,
    @SerializedName("quality")
    val quality: String? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("runtime")
    val runtime: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("titlereleased")
    val titlereleased: String? = null,
    @SerializedName("type")
    val type: String? = null
)