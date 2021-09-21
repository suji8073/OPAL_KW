package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class final_route_2 extends AppCompatActivity {

    Button next;
    ImageView circle1, circle2, circle3, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_route_2);

        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        circle1.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));


        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(final_route_2.this, final_route_3.class);
                startActivity(start_intent);
            }
        });

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




    }
}