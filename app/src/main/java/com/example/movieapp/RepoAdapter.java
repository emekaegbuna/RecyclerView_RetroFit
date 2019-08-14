package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.model.GetMoviePopular;
import com.example.movieapp.model.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private GetMoviePopular getMoviePopular;

    public RepoAdapter(GetMoviePopular getMoviePopular) {
        this.getMoviePopular = getMoviePopular;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_popular, parent, false);
        return new RepoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        final Result result = getMoviePopular.getResults().get(position);
        holder.tv_title.setText(result.getTitle());
        holder.tv_overview.setText(result.getOverview());
        holder.tv_rating.setRating(result.getVoteAverage().floatValue());
        Picasso.get().load("http://image.tmdb.org/t/p/w185" + result.getPosterPath()).into(holder.iv_main);

        /*holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(, SecondActivity.class);
                intent.putExtra(Constants.IMAGE_URL_INTENT, result.getPosterPath());
                intent.putExtra(Constants.TITLE_INTENT, result.getTitle());
                intent.putExtra(Constants.OVERVIEW_INTENT, result.getOverview());
                intent.putExtra(Constants.RATING_INTENT, result.getVoteAverage().toString());

                Constants.nContext.startActivity(intent);

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return getMoviePopular.getResults().size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_main;
        public TextView tv_title;
        public TextView tv_overview;
        public RatingBar tv_rating;
        public ConstraintLayout parentlayout;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_main = itemView.findViewById(R.id.iv_main);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_overview = itemView.findViewById(R.id.tv_overview);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            parentlayout = itemView.findViewById(R.id.rv_main_activity);


        }
    }
/*
    public interface OnCLickListener{
        void onCardClicked{}
    }*/


}
