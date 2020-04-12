package com.example.telstramachinetest.ui.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.telstramachinetest.R
import com.example.telstramachinetest.ui.data.RowsItem
import com.example.telstramachinetest.ui.data.db.NewsDatabase
import com.example.telstramachinetest.ui.data.network.NewsApi
import com.example.telstramachinetest.ui.data.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = ProgressBar.VISIBLE

        var listRowsItem = ArrayList<RowsItem>()



        val api = NewsApi()
        val db = NewsDatabase(this)
        val newsRepository = NewsRepository(api, db)
        val factory = NewsViewModelFactory(newsRepository)

        val viewModel = ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)

        viewModel.saveNews()

        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        val linearLayout : LinearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayout
        val adapter = NewsAdapter(context = this)
        recycler_view.adapter = adapter
        viewModel.getNewsFromDb().observe(this, Observer {

            it?.let {
                title_text.text = it.title
                listRowsItem = it.rows!! as ArrayList<RowsItem>

                it.rows?.let {

                    adapter.setList(it as ArrayList<RowsItem>)
                    progressBar.visibility = ProgressBar.GONE
                }
            }

        })
    }
}

