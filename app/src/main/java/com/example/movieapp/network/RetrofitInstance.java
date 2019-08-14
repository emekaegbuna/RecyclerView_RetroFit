package com.example.movieapp.network;

import com.example.movieapp.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        //initialize the retrofit var
        if(retrofit == null){
            //do something
            retrofit = new Retrofit.Builder()
                    //NEED TO CONCATINATE THE BASE_URL
                    .baseUrl(Constants.BASE_URL)
                    //NOW NEED TO CONVERT TO GSON
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    //FOR IT TO WORK NEED TO CLOSE IT
                    .build();


        }

        return retrofit;
    }
}
