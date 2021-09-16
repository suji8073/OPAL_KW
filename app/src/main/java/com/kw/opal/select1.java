package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class select1 extends AppCompatActivity {
    LinearLayout random, want;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select1);

        random = findViewById(R.id.random);
        want = findViewById(R.id.want);


        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select1.this, com.kw.opal.area.class);
                startActivity(start_intent);
            }
        });

        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select1.this, com.kw.opal.area.class);
                startActivity(start_intent);
            }
        });




    }
}