package com.ilyasmacit.tvserieskotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilyasmacit.tvserieskotlin.databinding.GenreViewBinding
import com.ilyasmacit.tvserieskotlin.databinding.RecyclerRowBinding
import com.ilyasmacit.tvserieskotlin.models.Genre

class GenreAdapter(var genreList : List<Genre>) : RecyclerView.Adapter<GenreAdapter.GenreHolder>() {
    class GenreHolder(var binding: GenreViewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreHolder {
        val binding = GenreViewBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return  GenreHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreHolder, position: Int) {
        holder.binding.genreText.text = genreList[position].value
    }

    override fun getItemCount(): Int  = genreList.size
}