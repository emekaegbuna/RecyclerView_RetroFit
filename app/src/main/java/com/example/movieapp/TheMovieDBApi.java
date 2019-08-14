package com.example.movieapp;

// import android.telecom.Call;

import com.example.movieapp.model.GetMoviePopular;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.http.Query;

public interface TheMovieDBApi {

    @GET("/3/movie/popular")
    Call<GetMoviePopular> getMoviePopular(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") String page);

}
