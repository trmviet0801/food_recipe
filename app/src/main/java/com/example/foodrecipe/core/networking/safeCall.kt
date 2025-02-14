package com.example.foodrecipe.core.networking

import com.example.foodrecipe.domain.util.NetworkError
import com.example.foodrecipe.domain.util.Result
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> safeCall(
    action: () -> HttpResponse
): Result<T, NetworkError> {
    val response = try {
        action()
    } catch (e: UnresolvedAddressException) {
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        return Result.Error(NetworkError.UNKNOWN)
    }
    return responseToResult(response)
}