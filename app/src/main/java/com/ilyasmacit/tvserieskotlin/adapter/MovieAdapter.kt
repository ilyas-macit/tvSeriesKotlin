package com.ilyasmacit.tvserieskotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilyasmacit.tvserieskotlin.databinding.RecyclerRowBinding
import com.ilyasmacit.tvserieskotlin.fragments.FirstFragment
import com.ilyasmacit.tvserieskotlin.fragments.FirstFragmentDirections
import com.ilyasmacit.tvserieskotlin.models.ResultX
import com.squareup.picasso.Picasso

class MovieAdapter(var results  : List<ResultX> , var context : Context): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    class MovieHolder (var binding : RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        var binding  = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.binding.movieTitle.text =results[position].title
        holder.binding.releaseDate.text = results[position].description
        holder.binding.ratingText.text = results[position].imDbRating
        Picasso.get().load(results[position].image).resize(100 , 100).into(holder.binding.movieImage)


        var adapter = GenreAdapter(results[position].genreList)
        holder.binding.genreList.layoutManager = GridLayoutManager(context , 2)
        holder.binding.genreList.adapter = adapter

        holder.binding.recyclerRow.setOnClickListener {
            var action = FirstFragmentDirections.actionMainFragmentToDetailFragment(results[position].id)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int = results.size
}