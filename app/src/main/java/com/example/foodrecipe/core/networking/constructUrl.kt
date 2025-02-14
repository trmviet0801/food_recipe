package com.example.foodrecipe.core.networking

import com.example.foodrecipe.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.RANDOM_URL) -> url
        else -> BuildConfig.SEARCH_BY_NAME_URL + url
    }
}