package com.example.moviestore.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestore.R
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movieList: List<MovieItem>, private val callBack: MovieCallBack) : RecyclerView.Adapter<MovieAdapter
.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent, false
        )
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]

        holder.imageView.setImageResource(currentItem.moviePicture)
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.genre
        holder.year.text = currentItem.year.toString()

        holder.itemView.setOnClickListener{
            callBack.onClick(position)
        }
    }

    override fun getItemCount() = movieList.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView
        val textView1 = itemView.textView1
        val textView2 = itemView.textView2
        val year = itemView.movieYear
    }
}