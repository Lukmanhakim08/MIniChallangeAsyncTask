package com.example.minichallange2

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minichallange2.Adapter.AdapterFIlm
import com.example.minichallange2.ViewModel.ViewModelFilm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapterfil : AdapterFIlm
    private lateinit var viewModel : ViewModelFilm
    private lateinit var cont : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cont = this
        FilmAsyncTask().execute()
    }

    inner class FilmAsyncTask() : AsyncTask<Void, Void, Void>(){
        private lateinit var loading : ProgressDialog
        override fun onPreExecute() {
            super.onPreExecute()
            loading = ProgressDialog(cont)
            loading.show()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            initRecylerView()
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            getDataFilm()
            loading.dismiss()
        }

        private fun getDataFilm() {
            viewModel = ViewModelProvider(this@MainActivity)
                .get(ViewModelFilm::class.java)
            viewModel.getliveDataFilm().observe(this@MainActivity, Observer {
                if (it.isNotEmpty()){
                    adapterfil.setDataFilm(it)
                    adapterfil.notifyDataSetChanged()
                }
            })
            viewModel.makeApiFilm()
        }

        private fun initRecylerView(){
            rv_film.layoutManager = LinearLayoutManager(cont)
            adapterfil = AdapterFIlm()
            rv_film.adapter = adapterfil
        }



    }
}