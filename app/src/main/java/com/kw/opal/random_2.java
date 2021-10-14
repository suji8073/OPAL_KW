package com.kw.opal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class random_2 extends AppCompatActivity {

    ImageView back_main;
    TextView theme_name, address, url;
    TextView text1_theme, text2_theme;
    String tourism_url;
    Button random_intent_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_2);

        theme_name = findViewById(R.id.theme_name); //관광지 이름
        address = findViewById(R.id.address); // 관광지 주소
        text1_theme = findViewById(R.id.text1_theme); //관광지 이용안내
        text2_theme = findViewById(R.id.text2_theme); // 관광지 상세정보
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


        back_main = findViewById(R.id.back_main); // 뒤로 가기 버튼
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void OnClickHandler(View view)
    {

        ContextThemeWrapper cw = new ContextThemeWrapper( this, R.style.AlertDialogTheme );
        AlertDialog.Builder builder = new AlertDialog.Builder(cw);
        builder.setMessage("선택하고 싶으면 '선택' 버튼을,\n취소하고 싶으시면 '취소' 버튼을 눌러주세요.\n");



        builder.setPositiveButton("선 택", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Intent start_intent = new Intent(getApplicationContext(), com.kw.opal.random_3.class);
                startActivity(start_intent);
            }
        });

        builder.setNegativeButton("취 소", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                finish();
            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}