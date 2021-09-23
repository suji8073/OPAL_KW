package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
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
        RetrofitService networkService = RetrofitHelper.create();

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkService.getList("city",1,"A0201")
                        .enqueue(new Callback<PointList>() {
                            @Override
                            public void onResponse(Call<PointList> call, Response<PointList> response) {
                                if(response.isSuccessful()){
                                    List point = Arrays.asList(response.body().pointlist);
                                    Intent play = new Intent(getApplicationContext(),root_making_1.class);
                                    play.putExtra("pointlist", (Parcelable) point);
                                    startActivity(play);
                                }

                            }

                            @Override
                            public void onFailure(Call<PointList> call, Throwable t) {

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