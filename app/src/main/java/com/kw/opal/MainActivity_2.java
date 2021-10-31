package com.kw.opal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity_2 extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView place1, back, next, root_picture;
    TextView place2;
    Button more;
    TextView root_place, root_1, root_2;

    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list1 = new ArrayList<>();
    public SharedPreferences sroot;
    int root_num = 0;
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    reDBOpenHelper helper;
    Cursor mCur;
    Context context;
    Cursor mCur1;

    int code;
    int cnt = 0;
    int next_page = 0;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        helper = new reDBOpenHelper(MainActivity_2.this);
        helper = new reDBOpenHelper(MainActivity_2.this);

        mCur1=helper.sortColumn();

        if (cnt > 0) {
            if (mCur1 != null && mCur1.moveToFirst()) {
                System.out.println(mCur1.getString(4));
                code = mCur1.getInt(7);
                System.out.println("코드는" + code);
            }
        }

        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);


        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);

        place1 = findViewById(R.id.place1);
        place2 = findViewById(R.id.place2);

        place1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        place2.setTextColor(getApplication().getResources().getColor(R.color.main));

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        back.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        next.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        root_place = findViewById(R.id.root_place); // 관광지의 이름이 들어가야 하는 곳 ex) 제주, 강릉, 강원도
        root_picture = findViewById(R.id.root_picture); // 관광지의 사진이 들어가야 하는 곳
        root_1 = findViewById(R.id.root_1); // 루트의 경로 ex) 해운대 - 광안리 - 카페 - 밥집 - 숙소
        // root_num에 root가 저장되어 있는 개수를 넣어줘! ex) 경로를 2개 생성하면 2개로!
        more = findViewById(R.id.more);
        mCur = helper.sortColumn();
        cnt = mCur.getCount()/3  ;

        if (cnt > 0) {
            set();//첫페이지 보여주기
            check_btn(cnt, next_page);


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (cnt - next_page > 1) {
                        next_page++;
                        check_btn(cnt, next_page);
                        list.clear();
                        code+=1;
                        if (code==1)
                            code+=1;
                        mCur=helper.selectC(String.valueOf(code));
                        System.out.println(mCur);
                        mCur.moveToFirst();
                        int id = R.drawable.no_camera;
                        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                        if (mCur.getString(3) != null) {
                            Glide.with(MainActivity_2.this).load(mCur.getString(3)).into(root_picture);
                        }
                        else {root_picture.setImageResource(id); }
                        mCur.moveToFirst();
                        if (mCur != null&& mCur.moveToFirst() ) {
                            System.out.println(mCur.getString(1));
                            root_place.setText(mCur.getString(8));
                            list.add(mCur.getString(2));
                            list.add("-");
                            while (mCur.moveToNext()) {
                                list.add(mCur.getString(2));

                                if (mCur.isLast() != true) {
                                    list.add("-");
                                }
                            }
                        }
                        System.out.println(mCur);


                        root_1.setText(TextUtils.join(" ", list));

                    }
                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cnt - next_page > 0 && next_page > 0) {
                        next_page--;
                        check_btn(cnt, next_page);
                        list.clear();
                        code-=1;
                        if (code==1)
                            code-=1;
                        mCur=helper.selectC(String.valueOf(code));
                        System.out.println(mCur);
                        mCur.moveToFirst();
                        int id = R.drawable.no_camera;
                        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                        if (mCur.getString(3) != null) {
                            Glide.with(MainActivity_2.this).load(mCur.getString(3)).into(root_picture);

                        }
                        else root_picture.setImageResource(id);
                        mCur.moveToFirst();
                        if (mCur != null&& mCur.moveToFirst() ) {

                            System.out.println(mCur.getString(1));
                            root_place.setText(mCur.getString(8));
                            list.add(mCur.getString(2));
                            list.add("-");
                            while (mCur.moveToNext()) {
                                list.add(mCur.getString(2));

                                if (mCur.isLast() != true) {
                                    list.add("-");
                                }
                            }
                        }
                        System.out.println(mCur);

                        root_1.setText(TextUtils.join(" ", list));

                    }
                }
            });



            more = findViewById(R.id.more);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent start_intent = new Intent(getApplicationContext(), tourism.class);
                    start_intent.putExtra("Id", "128205");
                    start_intent.putExtra("TypeId", "12");//휴양림 테스트
                    startActivity(start_intent);
                }
            });
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_2.this, com.kw.opal.MainActivity.class);
                startActivity(main_1);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_2.this, com.kw.opal.MainActivity_3.class);
                startActivity(main_1);
            }
        });


    }

    private void check_btn(int cnt, int next_page) {

        if(cnt - next_page > 1 ) { // 1>1
            next.setColorFilter(getApplication().getResources().getColor(R.color.main2));
            next.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_check_is));
        }
        else{
            next.setColorFilter(getApplication().getResources().getColor(R.color.gray));
            next.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_));

        }
        if (next_page > 0){
            back.setColorFilter(getApplication().getResources().getColor(R.color.main2));
            back.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_check_is));
        }
        else if (next_page == 0){
            back.setColorFilter(getApplication().getResources().getColor(R.color.gray));
            back.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.button_));
        }

    }


    public void set() {
        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!

        mCur=helper.selectC(String.valueOf(code));
        System.out.println(mCur);
        mCur.moveToFirst();
        int id = R.drawable.no_camera;
        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
        if (mCur.getString(3) != null) {
            Glide.with(MainActivity_2.this).load(mCur.getString(3)).into(root_picture);

        } else {root_picture.setImageResource(id);
        }
        mCur.moveToFirst();
        if (mCur != null&& mCur.moveToFirst() ){

            System.out.println(mCur.getString(1));

            root_place.setText(mCur.getString(8));
            list.add(mCur.getString(2));
            list.add("-");
            while(mCur.moveToNext()){
                list.add(mCur.getString(2));

                if(mCur.isLast()!=true){
                    list.add("-");
                }


            }
            System.out.println(mCur);


            root_1.setText(TextUtils.join(" ", list));

    }
}}