package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView home1, heart_1, heart_2;
    TextView home2;
    Button play;

    boolean i, j = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);

        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);

        home1 = findViewById(R.id.home1);
        home2 = findViewById(R.id.home2);


        home1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        home2.setTextColor(getApplication().getResources().getColor(R.color.main));

        heart_1 = findViewById(R.id.heart_1);
        heart_2 = findViewById(R.id.heart_2);

        heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));



        heart_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    heart_1.setImageResource(R.drawable.heart_on);
                    heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    i = false;
                }else {
                    heart_1.setImageResource(R.drawable.heart_off);
                    heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    i = true;
                }

            }
        });


        heart_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j == true){
                    heart_2.setImageResource(R.drawable.heart_on);
                    heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    j = false;
                }else {
                    heart_2.setImageResource(R.drawable.heart_off);
                    heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    j = true;
                }

            }
        });


        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity.this, MainActivity_2.class);
                startActivity(main_1);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity.this, MainActivity_3.class);
                startActivity(main_1);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(MainActivity.this, area.class);
                startActivity(start_intent);
            }
        });





    }
}