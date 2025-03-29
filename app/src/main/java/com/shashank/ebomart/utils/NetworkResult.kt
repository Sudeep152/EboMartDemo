package com.shashank.ebomart.utils

sealed class NetworkResult(data: Any? = null, message: String = "") {
    data class Success(val data: Any, val message: String = "") : NetworkResult(data,message)
    data class Error(val exception: String) : NetworkResult(message = exception)
}