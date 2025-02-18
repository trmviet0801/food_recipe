package com.example.foodrecipe.core.networking

import android.util.Log
import com.example.foodrecipe.domain.util.NetworkError
import com.example.foodrecipe.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

suspend inline fun <reified T> responseToResult(response: HttpResponse): Result<T, NetworkError> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success<T>(response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION)
            } catch (e: Exception) {
                Log.e("Network Error", "${e.message}")
                Result.Error(NetworkError.UNKNOWN)
            }
        }
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUEST)
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else ->  Result.Error(NetworkError.UNKNOWN)
    }
}