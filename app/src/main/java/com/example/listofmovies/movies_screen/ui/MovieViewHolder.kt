package com.example.listofmovies.movies_screen.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listofmovies.R
import com.example.listofmovies.movies_screen.MovieModel


class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imgOfMovie = itemView.findViewById<ImageView>(R.id.img_of_movie)
    val txtTitle = itemView.findViewById<TextView>(R.id.txt_title)
    val txtDescription = itemView.findViewById<TextView>(R.id.txt_description)

    fun showImage (movieItem: MovieModel) {
        Glide.with(imgOfMovie.context).load(movieItem.multimedia?.image).into(imgOfMovie)
    }

//    fun bind(movieItem: MovieModel) {
//
//    }
}