package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_2 extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView place1, back, next;
    TextView place2;
    Button more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);

        place1 = findViewById(R.id.place1);
        place2 = findViewById(R.id.place2);

        place1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        place2.setTextColor(getApplication().getResources().getColor(R.color.main));

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        back.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        next.setColorFilter(getApplication().getResources().getColor(R.color.gray));

        more = findViewById(R.id.more);




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_2.this, com.kw.opal.MainActivity.class);
                startActivity(main_1);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_2.this, com.kw.opal.MainActivity_3.class);
                startActivity(main_1);
            }
        });


    }
}