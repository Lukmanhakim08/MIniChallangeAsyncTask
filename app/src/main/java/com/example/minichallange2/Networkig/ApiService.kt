package com.example.minichallange2.Networkig

import com.example.minichallange2.Model.DataFilmResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("film")
    fun getAllFilm() : Call<List<DataFilmResponseItem>>
}