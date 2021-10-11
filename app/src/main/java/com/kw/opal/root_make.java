package com.kw.opal;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class root_make extends AppCompatActivity {
    Button finish_root;
    FrameLayout play, sleep, food;
    ImageView heart1, heart2, heart3, click1, click2, click3;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_make);
        final RSinterface networkService = RetrofitHelper.create();
        final WPClass post = new WPClass("city",1,"A0201");

        heart1=findViewById(R.id.heart1);
        heart1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart2=findViewById(R.id.heart2);
        heart2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart3=findViewById(R.id.heart3);
        heart3.setColorFilter(getApplication().getResources().getColor(R.color.heart));

        click1=findViewById(R.id.click1);
        click1.setColorFilter(getApplication().getResources().getColor(R.color.white));
        click2=findViewById(R.id.click2);
        click2.setColorFilter(getApplication().getResources().getColor(R.color.white));
        click3=findViewById(R.id.click3);
        click3.setColorFilter(getApplication().getResources().getColor(R.color.white));




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