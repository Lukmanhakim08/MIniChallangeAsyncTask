package com.example.minichallange2.Model


import com.google.gson.annotations.SerializedName

data class DataFilmResponseItem(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("judul")
    val judul: String
)