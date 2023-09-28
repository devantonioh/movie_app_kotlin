package com.aprenkotlin.mymovies.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.aprenkotlin.mymovies.R
import com.aprenkotlin.mymovies.databinding.ActivityDetailBinding
import com.aprenkotlin.mymovies.model.Movie
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            title = movie.title
            Glide
                .with(this)
                .load("https://image.tmdb.org/t/p/w780/${movie.backdrop_path}")
                .into(binding.ivBackdrop)
            // borrar los movie.overview
            binding.tvSummary.text = movie.overview + movie.overview + movie.overview

            bindDetaukinfo(binding.tvDetailInfo, movie)

            binding.fab.setOnClickListener {
                Toast.makeText(this, "Add Favorite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindDetaukinfo(tvDetailInfo: TextView, movie: Movie) {
        tvDetailInfo.text = buildSpannedString {
            appendInf(R.string.original_language, movie.original_language)
            appendInf(R.string.original_title, movie.original_title)
            appendInf(R.string.release_date, movie.release_date)
            appendInf(R.string.popularity, movie.popularity.toString())
            appendInf(R.string.vote_average, movie.vote_average.toString())

        }
    }

    private fun SpannableStringBuilder.appendInf(stringRes: Int, value: String) {
        bold {
            append(getString(stringRes))
            appendLine(": ")
        }
        appendLine(value)

    }
}