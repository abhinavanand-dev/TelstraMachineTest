package com.example.telstramachinetest.ui.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.telstramachinetest.ui.data.News
import com.example.telstramachinetest.ui.util.Converters

@Database(

    entities = [News::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {

        @Volatile
        private var instance: NewsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {

                instance
                    ?: buildDatabase(
                        context
                    ).also {

                        instance = it
                    }
            }

        private fun buildDatabase(context: Context) =

            Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}