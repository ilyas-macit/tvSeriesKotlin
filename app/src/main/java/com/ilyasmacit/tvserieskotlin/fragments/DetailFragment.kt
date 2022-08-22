package com.ilyasmacit.tvserieskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ilyasmacit.tvserieskotlin.databinding.FragmentDetailBinding
import com.ilyasmacit.tvserieskotlin.service.MovieServices
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DetailFragment : Fragment() {
    private val BASE_URL = "https://imdb-api.com/en/API/"
    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var id = DetailFragmentArgs.fromBundle(it).id
            var Api = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieServices::class.java)

            CoroutineScope(Dispatchers.IO).launch {
                var response = Api.detail(id)

                if (response.isSuccessful)
                {
                    withContext(Dispatchers.Main){
                        response.body()?.let{detail ->

                        }
                    }

                }
            }


        }


    }


}