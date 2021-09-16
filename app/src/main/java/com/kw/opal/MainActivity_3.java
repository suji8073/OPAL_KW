package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_3 extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView home1, place1, person1;
    TextView home2, place2, person2, main_text;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);


        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);

        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);



        person1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        person2.setTextColor(getApplication().getResources().getColor(R.color.main));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_3.this, com.kw.opal.MainActivity.class);
                startActivity(main_1);
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_3.this, MainActivity_2.class);
                startActivity(main_1);
            }
        });



    }
}