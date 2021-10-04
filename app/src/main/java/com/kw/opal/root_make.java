package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class root_make extends AppCompatActivity {
    Button play, food, sleep, finish_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_make);
        final RetrofitService networkService = RetrofitHelper.create();
        final PostClass post = new PostClass("city",1,"A0201");

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkService.setPostBody(post)
                        .enqueue(new Callback<PointList>() {
                            @Override
                            public void onResponse(Call<PointList> call, Response<PointList> response) {
                                if(response.isSuccessful()){
                                    List point = response.body().pointlist;
                                    ArrayList<PointModel> array = new ArrayList<>();
                                    array.addAll(point);

                                    Log.d("test",point.toString());
                                    Intent play = new Intent(getApplicationContext(),root_making_1.class);
                                    play.putExtra("pointlist", array);
                                    startActivity(play);
                                }
                            }
                            @Override
                            public void onFailure(Call<PointList> call, Throwable t) {
                                Log.d("test",t.toString());
                            }
                        });

            }
        });

        food = findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent food = new Intent(getApplicationContext(),root_making_2.class);
                startActivity(food);
            }
        });

        sleep = findViewById(R.id.sleep);
        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sleep = new Intent(getApplicationContext(),root_making_3.class);
                startActivity(sleep);
            }
        });


        finish_root = findViewById(R.id.finish_root);
        finish_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent finish_root = new Intent(getApplicationContext(),final_route_1.class);
                startActivity(finish_root);
            }
        });

    }
}