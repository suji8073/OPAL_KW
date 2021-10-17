package com.kw.opal;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tourism extends AppCompatActivity {

    ImageView back_main;
    TextView theme_name, address, url;
    TextView text0_theme,text1_theme;
    String tourism_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism);

        theme_name = findViewById(R.id.theme_name); //관광지 이름
        address = findViewById(R.id.address); // 관광지 주소
        text0_theme = findViewById(R.id.text0_theme); // 관광지 소개
        text1_theme = findViewById(R.id.text1_theme); //관광지 이용안내

        url = findViewById(R.id.url); // 관광지 홈페이지 url 넣을 장소
        url.setPaintFlags(url.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // 밑줄

        tourism_url = "http://www.camelliahill.co.kr"; // 관광지 홈페이지 넣으면 됨

        //url 클릭하면 해당 홈페이지로 이동
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tourism_url));
                startActivity(intent);

            }
        });



        back_main = findViewById(R.id.back_main);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}