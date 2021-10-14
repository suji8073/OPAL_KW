package com.kw.opal;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class random_1 extends AppCompatActivity {
    Integer[] FrameLayout = {R.id.random_1, R.id.random_2, R.id.random_3, R.id.random_4, R.id.random_5, R.id.random_6};
    FrameLayout[] layout = new FrameLayout[6]; // 뷰

    Integer[] r_name = {R.id.random_1_name, R.id.random_2_name, R.id.random_3_name, R.id.random_4_name, R.id.random_5_name, R.id.random_6_name};
    TextView[] name = new TextView[6]; // 텍스트

    Integer[] r_image = {R.id.random_1_image, R.id.random_2_image, R.id.random_3_image, R.id.random_4_image, R.id.random_5_image, R.id.random_6_image};
    ImageView[] image = new ImageView[6]; // 이미지

    LinearLayout reset;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_1);

        for (int i=0; i<FrameLayout.length; i++){ // layout 형변환
            layout[i] = findViewById(FrameLayout[i]);
        }
        for (int i= 0; i<r_name.length; i++){ // 이름 형변환
            name[i] = findViewById(r_name[i]);
        }
        for (int i= 0; i<r_image.length; i++){ // 이미지 형변환
            image[i] = findViewById(r_image[i]);
        }

        reset = findViewById(R.id.reset); //리셋버튼


        //해당 버튼이 눌리면 상세 페이지로 이동
        for (int i=0; i<layout.length; i++){
            final int INDEX;
            INDEX = i;

            layout[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent details =new Intent(getApplicationContext(), com.kw.opal.random_2.class);
                    startActivity(details);
                }
            });
        }
    }
}