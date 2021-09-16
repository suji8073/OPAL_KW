package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class taste1 extends AppCompatActivity {

    Button next;
    ImageView circle1, circle2, circle3, taste1_distance;
    ImageView taste1_1,taste1_2, taste1_3, taste1_4;

    Boolean[] empty = {false, false, false, false};


    int check = 1;
    int c = -1;


    Stack<ImageView> stack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taste1);

        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        taste1_distance = findViewById(R.id.taste1_distance);
        
        circle1.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));


        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(taste1.this, taste2.class);
                startActivity(start_intent);
            }
        });

        taste1_1 = findViewById(R.id.taste1_1);
        taste1_2 = findViewById(R.id.taste1_2);
        taste1_3 = findViewById(R.id.taste1_3);
        taste1_4 = findViewById(R.id.taste1_4);

        taste1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = click_check(1);
                check_num(taste1_1, c);
            }
        });

        taste1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = click_check(2);
                check_num(taste1_2, c);
            }
        });

        taste1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = click_check(3);
                check_num(taste1_3, c);
            }
        });

        taste1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = click_check(4);
                check_num(taste1_4, c);
            }
        });
    }


    public int click_check(int t){
        if (empty[t-1] == false){ // 체크가 안된 것
            empty[t-1] = true;
            return 0;
        }
        else {
            empty[t-1] = false;
            return 1;
        }
    }

    public void check_num(ImageView t, int c) { // 오답인지 정답인지 확인
        if (c == 0) {
            switch (check) {
                case 1:
                    t.setImageResource(R.drawable.one);
                    stack.push(t);
                    check += 1;
                    break;
                case 2:
                    t.setImageResource(R.drawable.two);
                    stack.push(t);
                    check += 1;
                    break;
                case 3:
                    t.setImageResource(R.drawable.three);
                    stack.push(t);
                    check += 1;
                    break;
                case 4:
                    t.setImageResource(R.drawable.four);
                    stack.push(t);
                    check += 1;
                    break;
            }
        }

        else if (c == 1) { //체크가 된 것
            if (stack.peek() == t) {
                t.setImageResource(0);
                check -= 1;
                stack.pop();
            }
        }


    }

}

