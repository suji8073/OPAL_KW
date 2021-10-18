package com.kw.opal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class root_make extends AppCompatActivity {
    Button finish_root;
    FrameLayout play, sleep, food, shop;
    ImageView heart1, heart2, heart3,heart4, click1, click2, click3,click4;
    rootDBOpenHelper helper;
    DbOpenHelper helper1;
    ArrayList<String> list=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_make);
        helper=new rootDBOpenHelper(this);
        helper1=new DbOpenHelper(this);


        heart1=findViewById(R.id.heart1);
        heart1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart2=findViewById(R.id.heart2);
        heart2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart3=findViewById(R.id.heart3);
        heart3.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart4=findViewById(R.id.heart4);
        heart4.setColorFilter(getApplication().getResources().getColor(R.color.heart));

        click1=findViewById(R.id.click1);
        click1.setColorFilter(getApplication().getResources().getColor(R.color.white));
        click2=findViewById(R.id.click2);
        click2.setColorFilter(getApplication().getResources().getColor(R.color.white));
        click3=findViewById(R.id.click3);
        click3.setColorFilter(getApplication().getResources().getColor(R.color.white));
        click4=findViewById(R.id.click4);
        click4.setColorFilter(getApplication().getResources().getColor(R.color.white));




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
        shop = findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop = new Intent(getApplicationContext(),root_making_4.class);
                startActivity(shop);
            }
        });

        final int[] i = {0};
        finish_root = findViewById(R.id.finish_root);
        int id = R.drawable.no_camera;
        finish_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String area;
                String image;
                Cursor mCur=helper1.selectColumns();
                if( mCur != null && mCur.moveToFirst() ) {
                    area = mCur.getString(7);
                    if(mCur.getString(3)!=null){image = mCur.getString(3);}
                    else{
                        image="null";}
                    list.add(mCur.getString(2));
                    while (mCur.moveToNext()) {
                        list.add(mCur.getString(2));
                        System.out.println(mCur.getString(2));
                    }
                    helper.insertColumn(String.valueOf(list.get(0)),String.valueOf(list.get(1)),String.valueOf(list.get(2)),String.valueOf(list.get(3)),area,image);
                    helper1.deleteAllColumns();

                    i[0]++;
                    System.out.println(i);
                }

                Intent finish_root = new Intent(getApplicationContext(),final_route_2.class);
                startActivity(finish_root);



            }
        });

    }
}