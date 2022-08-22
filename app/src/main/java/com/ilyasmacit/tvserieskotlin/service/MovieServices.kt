package com.ilyasmacit.tvserieskotlin.service

import com.ilyasmacit.tvserieskotlin.models.Detail
import com.ilyasmacit.tvserieskotlin.models.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieServices {

    //SearchMovie/k_0v380j1h/lord
    //AdvancedSearch/k_0v380j1h/?title=lord
    @GET("AdvancedSearch/k_0v380j1h/")
    suspend fun search(@Query("title") value : String) : Response<Movies>


    //Title/k_0v380j1h/{id}/FullActor,Posters,Images,Ratings,
    @GET("Title/k_0v380j1h/{id}/FullActor,Posters,Images,Ratings,")
    suspend fun detail(@Path("id") id : String) : Response<Detail>

}