package com.example.telstramachinetest.ui.util

import androidx.room.TypeConverter
import com.example.telstramachinetest.ui.data.News
import com.example.telstramachinetest.ui.data.RowsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()
    @TypeConverter
    fun convertTagsListToDb(tags: List<RowsItem>?): String? = if (tags != null) gson.toJson(tags) else null

    @TypeConverter
    fun convertDbToTags(value: String?): List<RowsItem> {
        if (value != null) {
            return gson.fromJson(value, News.messageOptionListType)
        }
        return listOf()
    }
}