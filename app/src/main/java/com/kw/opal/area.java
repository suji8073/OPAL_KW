package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class area extends AppCompatActivity {

    Button next;
    Integer[] check_num = {R.id.check1, R.id.check2, R.id.check3, R.id.check4, R.id.check5, R.id.check6,
            R.id.check7, R.id.check8, R.id.check9, R.id.check10,
            R.id.check11, R.id.check12, R.id.check13, R.id.check14, R.id.check15, R.id.check16, R.id.check17};

    Integer[] text_num = {R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6,
            R.id.text7, R.id.text8, R.id.text9, R.id.text10,
            R.id.text11, R.id.text12, R.id.text13, R.id.text14, R.id.text15, R.id.text16, R.id.text17};

    Integer[] layout_num = {R.id.layout1, R.id.layout2, R.id.layout3, R.id.layout4, R.id.layout5, R.id.layout6,
            R.id.layout7, R.id.layout8, R.id.layout9, R.id.layout10,
            R.id.layout11, R.id.layout12, R.id.layout13, R.id.layout14, R.id.layout15, R.id.layout16, R.id.layout17};

    ImageView[] check = new ImageView[17]; // 이미지

    TextView[] text = new TextView[17]; // 텍스트
    LinearLayout[] layout = new LinearLayout[17]; // 텍스트
    int one_pick = 0;
    int[] area_all = {1, 2, 3, 4, 5, 6, 7, 8, 31, 32, 33, 34, 35, 36, 37, 38, 39};

    public int[] on_off = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public SharedPreferences sroot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);

        for (int i=0; i<check_num.length; i++){ // board 형변환
            check[i] = findViewById(check_num[i]);
        }
        for (int i= 0; i<text_num.length; i++){ // 숫자 형변환
            text[i] = findViewById(text_num[i]);
        }
        for (int i= 0; i<layout_num.length; i++){ // layout 형변환
            layout[i] = findViewById(layout_num[i]);
        }



        for (int i=0; i<text_num.length; i++){
            final int INDEX;
            INDEX = i;

            layout[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int re = check_on_off(INDEX); // 체크 되었는지 표시
                    if (re == 0){ // 이미 체크된 것임
                        check[INDEX].setImageResource(R.drawable.check_off);
                        text[INDEX].setTextColor(getApplication().getResources().getColor(R.color.black));
                        layout[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                    }
                    else if (re == 1){ // 전에 체크 되지 않은 것
                        check[INDEX].setImageResource(R.drawable.check_on);
                        text[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                        layout[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                    }
                    else if (re == 2){ // 하나 이상 체크하려고 하는 경우
                        for (int i=0; i<on_off.length; i++){
                            if (on_off[i] == 1){
                                check[i].setImageResource(R.drawable.check_off);
                                text[i].setTextColor(getApplication().getResources().getColor(R.color.black));
                                layout[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                on_off[i] = 0;

                            }
                        }
                        check[INDEX].setImageResource(R.drawable.check_on);
                        text[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                        layout[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                        on_off[INDEX] = 1;

                    }


                }

            });
        }

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int click_check = 0;
                int area_num = 0;
                int string_area_index = -1;
                for (int i = 0; i<on_off.length; i++){
                    if (on_off[i] == 1) {
                        click_check = 1;
                        area_num = area_all[i];
                        string_area_index = i;
                    }
                }
                if (click_check == 1) {
                    SharedPreferences.Editor editor = sroot.edit();
                    editor.putString("area_name", text[string_area_index].getText().toString());
                    editor.putInt("area", area_num);
                    editor.commit();


                    Log.d("배열 확인", "배열: " + on_off);
                    Intent start_intent = new Intent(area.this, com.kw.opal.select1.class);
                    startActivity(start_intent);
                }

                else {
                    Toast.makeText(getApplicationContext(), "여행 지역을 선택하세요!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public int check_on_off(int index) { // 체크 되었는지 확인
        for (int i=0; i<on_off.length; i++){
            if (on_off[i] == 1){ //체크 된 것
                if (index == i) { //체크 된 것과 내가 클릭한 것이 같으면 다시 체크안 된 것으로
                    on_off[i] = 0;
                    one_pick -= 1;
                    return 0;
                }
            }
        }
        if (one_pick == 1){
            return 2;
        }
        // 전에 체크 되지 않은 것
        on_off[index] = 1;
        one_pick += 1;
        return 1;
    }
}