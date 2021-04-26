package com.example.moviestore

import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviestore.data.MovieAdapter
import com.example.moviestore.data.MovieCallBack
import com.example.moviestore.data.MovieItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieCallBack {

    val list = listOf(
        R.raw.hachiko, R.raw.everafter, R.raw.forrest_gump,
        R.raw.hacksaw_ridge, R.raw.garry_potter_first, R.raw.one_plus_one, R.raw.percy_jecson,
        R.raw.indiana_jones,R.raw.chronicles_of_narnia,R.raw.mechanic,R.raw.ratatouille,
        R.raw.gladiator,R.raw.letters_to_juliet

    )
    lateinit var offlineUrl: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView = findViewById<VideoView>(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        var movieList = listOf<MovieItem>(
            MovieItem(R.drawable.movie1, "Hachiko", "Child,Comedy", 2009),
            MovieItem(R.drawable.movie2, "Ever After", "Drama,Comedy,Melodrama", 1998),
            MovieItem(R.drawable.movie3, "Forrest Gump", "Thriller", 1994),
            MovieItem(R.drawable.movie4, "Hacksaw Ridge", "Drama, Military,Biography,History", 2016),
            MovieItem(R.drawable.movie5, "Harry Potter and the Philosopher's Stone ", "Fantasy", 2001),
            MovieItem(R.drawable.movie6, "1+1", "Comedy, Drama", 2011),
            MovieItem(R.drawable.movie7, "Percy Jackson and the Lightning Thief", "Fantasy", 2010),
            MovieItem(R.drawable.movie8,"Indiana Jones and the Last Crusade","Adventure, Action",1989),
            MovieItem(R.drawable.movie9,"The Chronicles of Narnia: Prince Caspian","Fantasy,Adventure,Action,Family",2008),
            MovieItem(R.drawable.movie10,"The Mechanic","Thriller,Action",2010),
            MovieItem(R.drawable.movie11,"Ratatouille","Fantasy,Action,Adventure,Cartoon,Family,Comedy,Drama",2007),
            MovieItem(R.drawable.movie12,"Gladiator","Action,History,Drama,Adventure",2000),
            MovieItem(R.drawable.movie13,"Letters to Juliet","Drama,Comedy,Adventure,Melodrama",2010)
        )
        recyclerView.adapter = MovieAdapter(movieList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        videoView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        offlineUrl = Uri.parse("android.resource://$packageName/${list.get(position)}")
        videoView.run {
            videoView.setVideoURI(offlineUrl)
            videoView.requestFocus()
            videoView.start()
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

    }

    override fun onBackPressed() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        videoView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE



    }


}
