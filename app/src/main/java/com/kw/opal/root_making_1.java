package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class root_making_1 extends AppCompatActivity {
    Button finish;
    Intent intent = getIntent();
    PointModel pointlist = (PointModel) intent.getSerializableExtra("pointlist");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("test",pointlist.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_making_1);

        finish = findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}