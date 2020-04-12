package com.example.telstramachinetest.ui.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.telstramachinetest.R
import com.example.telstramachinetest.ui.data.RowsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_layout.view.*


class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    private var listRowsItem: List<RowsItem> = ArrayList<RowsItem>()

    fun setList(items: ArrayList<RowsItem>) {

        listRowsItem = items
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false)

        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {

        return listRowsItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(rowsItem = listRowsItem.get(position))
    }

    class ViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView) {

        fun bindView(rowsItem: RowsItem) {

            itemView.title_text.text = rowsItem.title
            itemView.text_description.text = rowsItem.description
            itemView.text_description.text = rowsItem.description
            val aUrl: String = rowsItem.imageHref!!.replace("http", "https")
            try {
                Picasso.get()
                    .load(aUrl)
                    .resize(80, 80)
                    .centerCrop()
                    .into(itemView.image_view)
            } catch (e: Exception) {

                e.printStackTrace()
            }
        }

    }
}