package com.movie.movieclean.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.movie.movieclean.databinding.MovieItemBinding
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.presentation.diffutill.MovieDiffCallback

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var listMovie = emptyList<Movie>()

    lateinit var onItemClick: ((Movie) -> Unit)

    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context
        ), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemList = listMovie[position]
        with(holder.binding) {
            root.setOnClickListener {
                onItemClick.invoke(itemList)
            }
            nameMovie.text = itemList.title
            Glide.with(root.context)
                .load("https://image.tmdb.org/t/p/w342" + itemList.poster_path)
                .into(imageMovie)
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    fun setData(list: List<Movie>) {
        val callback = MovieDiffCallback(listMovie, list)
        val result = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
        listMovie = list
    }
}