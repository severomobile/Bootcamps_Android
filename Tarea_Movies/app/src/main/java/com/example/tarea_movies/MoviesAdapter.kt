package com.example.tarea_movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tarea_movies.databinding.ViewMovieItemBinding
import com.example.tarea_movies.model.Movie

class MoviesAdapter(
    var movies: List<Movie>,
    private val movieClickedListener: (Movie) -> Unit

) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
                .into(binding.cover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {movieClickedListener(movie)}
    }
}