package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

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


        /* random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select1.this, com.kw.opal.random_1.class);
                startActivity(start_intent);
            }
        });*/

        want.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_i = new Intent(select1.this, com.kw.opal.root_making.class);
                startActivity(start_i);
            }
        });


        int area = sroot.getInt("area",0);
        String area_name = sroot.getString("area_name", "");
        Log.e("area_num", "내가 선택한 지역 " + area);
        Log.e("area_name", "내가 선택한 지역 이름 " + area_name);



    }
}