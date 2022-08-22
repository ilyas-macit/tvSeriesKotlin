package com.ilyasmacit.tvserieskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilyasmacit.tvserieskotlin.adapter.MovieAdapter
import com.ilyasmacit.tvserieskotlin.databinding.FragmentDetailBinding
import com.ilyasmacit.tvserieskotlin.databinding.FragmentMainBinding
import com.ilyasmacit.tvserieskotlin.models.Movies
import com.ilyasmacit.tvserieskotlin.service.MovieServices
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FirstFragment : Fragment() {
    val BASE_URL = "https://imdb-api.com/API/"
    // AdvancedSearch/k_0v380j1h/?title=lord

    //old url
    //val BASE_URL = "https://imdb-api.com/en/API/"
    // /en/API/SearchMovie/k_0v380j1h/lord
    private lateinit var binding : FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.searchBtn.setOnClickListener {
            search(view)
        }

    }



    fun search(view: View){

        var api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieServices::class.java)



        CoroutineScope(Dispatchers.IO).launch{

            var response = api.search(binding.name.text.toString())
            binding.name.setText("")

            if(response.isSuccessful){

                withContext(Dispatchers.Main){
                    response.body()?.let {

                        var results = it.results
                        if (results != null){
                            println("results is not empty ")
                            val adapter = MovieAdapter(results , view.context)
                            binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
                            binding.recyclerView.adapter = adapter
                        }

                    }
                }

            }
        }


    }


}