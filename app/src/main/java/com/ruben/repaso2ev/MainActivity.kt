package com.ruben.repaso2ev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.room.Room
import com.ruben.repaso2ev.database.MoviesDatabase
import com.ruben.repaso2ev.database.toDatabase
import com.ruben.repaso2ev.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: MoviesDatabase
    private lateinit var rv: RecyclerView
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(this, MoviesDatabase::class.java, "movies_database").build()
        val dataList = MoviesProvider.getMovies()
        val entityList = dataList.map { it.toDatabase() }

        adapter = MoviesAdapter()
        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = adapter

        CoroutineScope(Dispatchers.IO).launch {
            db.getMoviesDao().deleteAllMovies()
            db.getMoviesDao().insertAll(entityList)
            val lista = db.getMoviesDao().getAllMovies()
            runOnUiThread {
                adapter.updateList(lista)
            }
        }
    }

}