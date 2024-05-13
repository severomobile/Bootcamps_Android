package com.example.tarea_movies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea_movies.databinding.ActivityMainBinding
import com.example.tarea_movies.model.MovieDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(emptyList())
        { movie ->
            Toast.makeText(this, movie.title, Toast.LENGTH_SHORT).show()
        }

        binding.recycler.adapter = moviesAdapter

        thread {
            val token = getString(R.string.api_token)
            val popularMovies = MovieDbClient.service.listPopularMovies("Bearer $token")
            val response = popularMovies.execute()

            runOnUiThread {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        moviesAdapter.movies = body.results
                        moviesAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
