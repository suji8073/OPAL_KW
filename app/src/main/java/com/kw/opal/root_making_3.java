package com.kw.opal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class root_making_3 extends AppCompatActivity {
    Button finish;
    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_making_3);

        finish = findViewById(R.id.finish3);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(getApplicationContext(), root_make.class);
                startActivity(start_intent);
            }
        });


        cart = findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(getApplicationContext(), final_route_2.class);
                start_intent.putExtra("check", 0);
                startActivity(start_intent);
            }
        });

    }
}