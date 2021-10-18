package com.kw.opal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity_2 extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView place1, back, next, root_picture;
    TextView place2;
    Button more;
    TextView root_place, root_1, root_2;
    rootDBOpenHelper helper;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list1 = new ArrayList<>();
    public SharedPreferences sroot;
    int root_num = 0;
    HashMap<Integer, String> map = new HashMap<Integer, String>();

    Cursor mCur;
    Context context;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        helper = new rootDBOpenHelper(MainActivity_2.this);
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

        set();//첫페이지 보여주기



            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    int id = R.drawable.no_camera;
                    // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                    if (mCur != null&& mCur.moveToNext() ){
                        System.out.println(mCur);
                        System.out.println(mCur.getString(1));
                        root_place.setText(mCur.getString(4));
                        if (mCur.getString(5) != null) {
                            Glide.with(MainActivity_2.this).load(mCur.getString(5)).into(root_picture);
                        } else {root_picture.setImageResource(id);
                        }}
                    root_1.setText(mCur.getString(0) + "-" + mCur.getString(1) + "-" + mCur.getString(2) + "-" + mCur.getString(3));



                    System.out.println(mCur);

                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int id = R.drawable.no_camera;
                    // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                    if (mCur != null&& mCur.moveToPrevious() ){
                        System.out.println(mCur);
                        System.out.println(mCur.getString(1));
                        root_place.setText(mCur.getString(4));
                        if (mCur.getString(5) != null) {
                            Glide.with(MainActivity_2.this).load(mCur.getString(5)).into(root_picture);
                        } else {root_picture.setImageResource(id);
                        }}
                    root_1.setText(mCur.getString(0) + "-" + mCur.getString(1) + "-" + mCur.getString(2) + "-" + mCur.getString(3));

                }
            });

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

        more = findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(getApplicationContext(), tourism.class);
                startActivity(start_intent);
            }
        });


    }




    public void set() {
        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!


        int id = R.drawable.no_camera;
        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
        if (mCur != null&& mCur.moveToFirst() ){
            System.out.println(mCur);
            System.out.println(mCur.getString(1));
            root_place.setText(mCur.getString(4));
                if (mCur.getString(5) != null) {
                    Glide.with(MainActivity_2.this).load(mCur.getString(5)).into(root_picture);
                } else {root_picture.setImageResource(id);
                }}
        root_1.setText(mCur.getString(0) + "-" + mCur.getString(1) + "-" + mCur.getString(2) + "-" + mCur.getString(3));


    }
}