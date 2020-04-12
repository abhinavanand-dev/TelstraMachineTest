package com.example.telstramachinetest.ui.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
const val PRIMARY_KEY = 0
@Entity
data class News(@SerializedName("title")
                val title: String = "",
                @SerializedName("rows")
                val rows: List<RowsItem>?){
    @PrimaryKey(autoGenerate = true)
    var id = PRIMARY_KEY
   companion object{

       @Ignore
       val messageOptionListType: Type = object : TypeToken<List<RowsItem>>() {}.type
   }
}
