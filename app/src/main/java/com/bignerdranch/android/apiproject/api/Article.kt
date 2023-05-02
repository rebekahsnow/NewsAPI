package com.bignerdranch.android.apiproject.api

import android.net.Uri
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Article(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,

)

data class ArticleResponse(@Json(name="articles")
var result : List<Article>)