package com.kw.opal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class smart_root extends AppCompatActivity {

    Button smart_root_check, smart_root_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_root);

        smart_root_check = findViewById(R.id.smart_root_check); // 선택하기 버튼
        smart_root_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        smart_root_no = findViewById(R.id.smart_root_no); // 취소하기 버튼
        smart_root_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}