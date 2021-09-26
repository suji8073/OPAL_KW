package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class root_making_1 extends AppCompatActivity {
    Button finish;
    Intent intent = getIntent();

    ImageView cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            ArrayList<PointList> pointlist = (ArrayList<PointList>) intent.getSerializableExtra("pointlist");
            Log.d("test",pointlist.toString());

        }catch (NullPointerException e){
            Log.d("test","왜뜨는거지");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_making_1);

        finish = findViewById(R.id.finish);
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