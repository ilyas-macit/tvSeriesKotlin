package com.ilyasmacit.tvserieskotlin.models

data class Movies(
    val errorMessage: Any,
    val queryString: String,
    val results: List<ResultX>
)