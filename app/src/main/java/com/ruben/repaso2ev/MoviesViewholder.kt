package com.ruben.repaso2ev

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ruben.repaso2ev.database.MovieEntity
import com.ruben.repaso2ev.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MoviesViewholder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemLayoutBinding.bind(view)

    fun bind(movie: MovieEntity){
        Picasso.get().load(movie.image).into(binding.ivMovie)
        binding.tvTitle.text = movie.title
        binding.tvDirector.text = movie.director
        binding.tvGenre.text = movie.genre
        binding.tvDuration.text = movie.duration
        binding.tvSynopsis.text = movie.synopsis
        binding.tvReleaseDate.text = movie.releaseDate
        binding.tvLeadActor.text = movie.leadActor
        val w1 = movie.writer1
        val w2 = movie.writer2
        val w3 = movie.writer3
        val w4 = movie.writer4
        binding.tvWriters.text = "$w1\n $w2\n $w3\n $w4\n"
    }
}