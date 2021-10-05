package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class select1 extends AppCompatActivity {
    LinearLayout random, want;
    private SharedPreferences sroot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select1);

        random = findViewById(R.id.random);
        want = findViewById(R.id.want);
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);


        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select1.this, com.kw.opal.root_make.class);
                startActivity(start_intent);
            }
        });

        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select1.this, com.kw.opal.root_make.class);
                startActivity(start_intent);
            }
        });


        int area = sroot.getInt("area",0);
        Log.e("area_num", "내가 선택한 지역 " + area);



    }
}