package com.example.telstramachinetest.ui.data

import com.google.gson.annotations.SerializedName

data class RowsItem(@SerializedName("imageHref")
                    val imageHref: String? = "",
                    @SerializedName("description")
                    val description: String? = "",
                    @SerializedName("title")
                    val title: String? = "")