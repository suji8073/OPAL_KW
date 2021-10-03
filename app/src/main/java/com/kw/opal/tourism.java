package com.kw.opal;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tourism extends AppCompatActivity {

    ImageView back_main;
    TextView address, url;
    String tourism_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism);


        back_main = findViewById(R.id.back_main);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        address = findViewById(R.id.address); // 주소
        url = findViewById(R.id.url); // url

        tourism_url = "http://www.camelliahill.co.kr";
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tourism_url));
                startActivity(intent);

            }
        });



    }
}