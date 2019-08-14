package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.movieapp.model.GetMoviePopular;
import com.example.movieapp.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv_main_activity);

        TheMovieDBApi theMovieDBApi = RetrofitInstance.getRetrofitInstance().create(TheMovieDBApi.class);
        Call<GetMoviePopular> call = theMovieDBApi.getMoviePopular("<<api_key>>", "en-US", "1");
        call.enqueue(new Callback<GetMoviePopular>() {
            @Override
            public void onResponse(Call<GetMoviePopular> call, Response<GetMoviePopular> response) {

                GetMoviePopular getMoviePopular = response.body();
                Log.d("CALLEXAMPLE", getMoviePopular.getResults().get(0).getTitle());
                mAdapter = new RepoAdapter(getMoviePopular);

                mLayoutManager = new LinearLayoutManager(MainActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);



            }

            @Override
            public void onFailure(Call<GetMoviePopular> call, Throwable t) {

            }
        });







    }
}
