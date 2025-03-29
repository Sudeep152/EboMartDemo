package com.shashank.ebomart.routes

import kotlinx.serialization.Serializable


@Serializable
sealed class EBOAppRoutes {

    @Serializable
    data object HomeScreen : EBOAppRoutes()

    @Serializable
    data class DetailScreen(val id: String) : EBOAppRoutes()

}