package com.bignerdranch.android.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bignerdranch.android.apiproject.api.ApiClient
import com.bignerdranch.android.apiproject.api.ArticleResponse
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = ApiClient.apiService.fetchArticles()
        client.enqueue(object: retrofit2.Callback<ArticleResponse>{
            override fun onResponse(
                call: Call<ArticleResponse>,
                response: Response<ArticleResponse>
            ){
                if(response.isSuccessful){
                    Log.d("articles ",""+response.body())
                    val result = response.body()?.result
                    result?.let{
                        val adapter = ArticleAdapter(result)
                        val recyclerView = findViewById<RecyclerView>(R.id.articlesRv)
                        recyclerView?.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
                        recyclerView?.adapter = adapter
                    }
                }
            }
            override fun onFailure(call: Call<ArticleResponse>, t: Throwable){
                Log.d("failed",""+t.message)
            }

        })
    }
}