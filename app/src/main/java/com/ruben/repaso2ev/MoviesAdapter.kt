package com.ruben.repaso2ev

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ruben.repaso2ev.database.MovieEntity

class MoviesAdapter(var lista: List<MovieEntity> = emptyList()) : RecyclerView.Adapter<MoviesViewholder>() {

    fun updateList(list: List<MovieEntity>) {
        lista = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewholder {
        return MoviesViewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewholder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount() = lista.size
}