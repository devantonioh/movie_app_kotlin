package com.aprenkotlin.mymovies.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aprenkotlin.mymovies.databinding.ViewMovieItemBinding
import com.aprenkotlin.mymovies.model.Movie
import com.bumptech.glide.Glide

//interface MovieClickListener {
//    fun onMovieClick(movie: Movie) //(Movie) -> Unit
//}

class MoviesAdapter(
     var movies: List<Movie>,
     private val movieClickListener: (Movie) -> Unit //MovieClickListener
) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )

        return ViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = movies[position]
        holder.bind(movies)
        holder.itemView.setOnClickListener {
            movieClickListener(movies)
        }
    }

    class ViewHolder(private val binding: ViewMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.tvTitle.text = movie.title
            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w185/${movie.poster_path}")
                .into(binding.ivCover)

        }
    }
}