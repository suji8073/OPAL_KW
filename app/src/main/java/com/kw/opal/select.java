package com.kw.opal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class select extends AppCompatActivity {
    ImageView sub1, sub2, add1, add2;
    TextView text1, text2;
    Button next;


    TextView[] num = new TextView[10]; // 숫자를 채울 TextView
    Integer[] choice = {R.id.choice1_1, R.id.choice1_2, R.id.choice2_1, R.id.choice2_2, R.id.choice3_1, R.id.choice3_2,
            R.id.choice3_3, R.id.choice4_1, R.id.choice4_2, R.id.choice4_3};
    int[] check = new int[10];

    int num1 = 1;
    int num2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        for (int i= 0; i<choice.length; i++){ // 숫자 형변환
            num[i] = findViewById(choice[i]);
        }

         for (int i=0; i<num.length; i++) {

             final int INDEX;
             INDEX = i;


             num[INDEX].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     check[INDEX] = check[INDEX] + 1;
                     if (check[INDEX] % 2 != 0) {
                         num[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                         num[INDEX].setTextColor(Color.parseColor("#398EEC"));
                     }
                     else {
                         num[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                         num[INDEX].setTextColor(Color.parseColor("#000000"));
                     }

                 }
             });
         }



        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        next = findViewById(R.id.next);

        sub1.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        sub2.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        add1.setColorFilter(getApplication().getResources().getColor(R.color.black));
        add2.setColorFilter(getApplication().getResources().getColor(R.color.black));


        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1 > 1) {
                    sub1.setColorFilter(getApplication().getResources().getColor(R.color.black));
                    num1 -= 1;
                }
                if (num1 == 1)
                    sub1.setColorFilter(getApplication().getResources().getColor(R.color.gray));

                text1.setText(num1 + "명");

            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num2 > 1) {
                    sub2.setColorFilter(getApplication().getResources().getColor(R.color.black));
                    num2 -= 1;
                }
                if (num2 == 1)
                    sub2.setColorFilter(getApplication().getResources().getColor(R.color.gray));

                text2.setText(num2 + "일");

            }
        });
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub1.setColorFilter(getApplication().getResources().getColor(R.color.black));
                num1 += 1;
                text1.setText(num1 + "명");

            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub2.setColorFilter(getApplication().getResources().getColor(R.color.black));
                num2 += 1;

                text2.setText(num2 + "일");

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(select.this, select1.class);
                startActivity(start_intent);
            }
        });




    }
}