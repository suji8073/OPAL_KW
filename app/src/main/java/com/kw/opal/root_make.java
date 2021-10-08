package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class root_make extends AppCompatActivity {
    Button play, food, sleep, finish_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_make);
        final RSinterface networkService = RetrofitHelper.create();
        final WPClass post = new WPClass("city",1,"A0201");

        play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent play = new Intent(getApplicationContext(),root_making_1.class);
                startActivity(play);

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