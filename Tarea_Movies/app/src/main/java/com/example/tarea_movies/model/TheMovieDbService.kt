package com.example.tarea_movies.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TheMovieDbService {
   @GET("movie/popular")
   @Headers("Accept: application/json")
   fun listPopularMovies(@Header("Authorization") token: String): Call<MovieDbResult>
}


