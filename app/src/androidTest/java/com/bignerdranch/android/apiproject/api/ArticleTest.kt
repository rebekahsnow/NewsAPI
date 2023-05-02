package com.bignerdranch.android.apiproject.api

import com.bignerdranch.android.apiproject.ArticleAdapter
import org.junit.Assert
import org.junit.Test

class ArticleAdapterTest {

    @Test
    fun testAdapterItemCount() {

        val articleList = listOf(
            Article("Mariella Moon", "Beats Studio Buds+ leak on Amazon with a May 18th release date", "description", "https://url1.com", "https://urlToImage1.com", "2023-04-26T09:16:39Z"),
            Article("author2", "title2", "description2", "https://url2.com", "https://urlToImage2.com","2023-04-24T12:35:45.1234567Z")
        )
        val adapter = ArticleAdapter(articleList)
        Assert.assertEquals(articleList.size, adapter.itemCount)
    }

}