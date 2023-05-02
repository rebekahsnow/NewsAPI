package com.bignerdranch.android.apiproject.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "88273d2b8a1c4c0486d16a8f6bd218ee"
//top-headlines?country=us&88273d2b8a1c4c0486d16a8f6bd218ee

object ApiClient {
    private const val BASE_URL = "https://newsapi.org/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val apiService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET(
        "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=$API_KEY"
    )
    fun fetchArticles(): Call<ArticleResponse>
}
