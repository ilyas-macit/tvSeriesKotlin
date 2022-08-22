package com.ilyasmacit.tvserieskotlin.models

data class ResultX(
    val contentRating: String,
    val description: String,
    val genreList: List<Genre>,
    val genres: String,
    val id: String,
    val imDbRating: String,
    val imDbRatingVotes: String,
    val image: String,
    val metacriticRating: String,
    val plot: String,
    val runtimeStr: String,
    val stars: String,
    val title: String
)