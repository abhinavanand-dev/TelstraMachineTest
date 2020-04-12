package com.example.telstramachinetest.ui.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.telstramachinetest.ui.data.News
import com.example.telstramachinetest.ui.data.repository.NewsRepository
import com.example.telstramachinetest.ui.util.ApiException
import com.example.telstramachinetest.ui.util.Coroutines
import com.example.telstramachinetest.ui.util.NoInternetException

class NewsViewModel(val newsRepository: NewsRepository) : ViewModel() {


    fun saveNews() {

        Coroutines.main {

            val newsResponse: News = newsRepository.getNewsDataFromNetwork()

            try {

                newsResponse?.let {

                    newsRepository.saveNews(it)
                }

            } catch (e: ApiException) {

                e.printStackTrace()

            } catch (e: NoInternetException) {

                e.printStackTrace()
            }
        }
    }

    fun getNewsFromDb() : LiveData<News> =

            newsRepository.getNewsFromDb()
}