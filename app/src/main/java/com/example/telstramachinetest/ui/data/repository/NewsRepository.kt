package com.example.telstramachinetest.ui.data.repository

import androidx.lifecycle.LiveData
import com.example.telstramachinetest.ui.data.News
import com.example.telstramachinetest.ui.data.db.NewsDatabase
import com.example.telstramachinetest.ui.data.network.NewsApi
import com.example.telstramachinetest.ui.data.network.SafeApiRequest

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsDatabase: NewsDatabase
) : SafeApiRequest() {

    suspend fun getNewsDataFromNetwork(): News{//LiveData<News> {

       // return newsApi.getData()

       return apiRequest { newsApi.getData() }
    }

    fun getNewsFromDb(): LiveData<News> {

        return newsDatabase.getNewsDao().getNews()
    }
    suspend fun saveNews(news: News) {

        newsDatabase.getNewsDao().upsert(news)
    }
}


////suspend
//fun getNewsDataFromNetwork(): LiveData<News> {
//
//    return newsApi.getData()
//
//    //apiRequest { newsApi.getData() }
//}
//
//fun getNewsFromDb(): LiveData<News> {
//
//    return newsDatabase.getNewsDao().getNews()
//}
//
//// suspend
//fun saveNews(news: News) {
//
//    newsDatabase.getNewsDao().upsert(news)
//}
