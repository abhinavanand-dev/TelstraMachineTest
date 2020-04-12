package com.example.telstramachinetest.ui.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.telstramachinetest.ui.data.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(news: News): Long

    @Query("SELECT * FROM news")
    fun getNews(): LiveData<News>

}