package com.example.minichallange2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minichallange2.Model.DataFilmResponseItem
import com.example.minichallange2.Networkig.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelFilm : ViewModel() {
    lateinit var liveDataFilm : MutableLiveData<List<DataFilmResponseItem>>

    init {
        liveDataFilm = MutableLiveData()
    }

    fun getliveDataFilm() : MutableLiveData<List<DataFilmResponseItem>>{
        return liveDataFilm
    }

    fun makeApiFilm(){
        ApiClient.instance.getAllFilm()
            .enqueue(object : Callback<List<DataFilmResponseItem>>{
                override fun onResponse(
                    call: Call<List<DataFilmResponseItem>>,
                    response: Response<List<DataFilmResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataFilm.postValue(response.body())
                    }else{
                        liveDataFilm.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<DataFilmResponseItem>>, t: Throwable) {
                    liveDataFilm.postValue(null)
                }

            })
    }
}