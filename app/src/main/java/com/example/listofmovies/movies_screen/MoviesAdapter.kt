package com.example.listofmovies.movies_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.listofmovies.R
import com.example.listofmovies.movies_screen.ui.MovieViewHolder

class MoviesAdapter : PagingDataAdapter<MovieModel, MovieViewHolder>(MovieModelDiffItemCallBack()) {

//    private val movieList: MutableList<MovieModel> = mutableListOf()

//    fun updateListOfMovies(movieList: List<MovieModel>) {
//        this.movieList.addAll(movieList)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_list, parent, false)
        return MovieViewHolder(view)
    }

//    override fun getItemCount(): Int {
//        return movieList.size
//    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let {
            holder.txtTitle.text = it.title
            holder.txtDescription.text = it.description
            holder.showImage(it)
        }
    }
}

class MovieModelDiffItemCallBack : DiffUtil.ItemCallback<MovieModel>() {
    override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
        return oldItem.title == newItem.title
                && oldItem.description == newItem.description
                && oldItem.multimedia?.image == newItem.multimedia?.image
    }

}