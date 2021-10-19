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

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class final_route_3 extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView place1, back,  root_picture;
    TextView place2;
    TextView root_place, root_1, root_2;

    ArrayList<String> list = new ArrayList<>();
    public SharedPreferences sroot1;


    HashMap<Integer, String> map = new HashMap<Integer, String>();

    Cursor mCur;

    Button next, more;
    ImageView circle1, circle2, circle3;
    reDBOpenHelper helper;
    DbOpenHelper helper1;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_route_3);
        sroot1 = getSharedPreferences("code", Activity.MODE_PRIVATE);

        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        helper=new reDBOpenHelper(this);
        helper1=new DbOpenHelper(this);

        circle1.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.main2));



        root_place = findViewById(R.id.root_place); // 관광지의 이름이 들어가야 하는 곳 ex) 제주, 강릉, 강원도
        root_picture = findViewById(R.id.root_picture); // 관광지의 사진이 들어가야 하는 곳
        root_1 = findViewById(R.id.root_1); // 루트의 경로 ex) 해운대 - 광안리 - 카페 - 밥집 - 숙소
        // root_num에 root가 저장되어 있는 개수를 넣어줘! ex) 경로를 2개 생성하면 2개로!



        set();//첫페이지 보여주기
        final int[] i = {0};
        next = findViewById(R.id.next);
        int id = R.drawable.no_camera;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String area;
                String image;
                String id;
                String name;
                String addr;
                Float x;
                Float y;
                int code = sroot1.getInt("code",0);


                Cursor mCur=helper1.selectColumns();

                if( mCur != null && mCur.moveToFirst() ) {
                    while(mCur.moveToNext()){

                    id=mCur.getString(1);
                    name=mCur.getString(2);
                    image = mCur.getString(3);
                    addr=mCur.getString(4);
                    x=mCur.getFloat(5);
                    y=mCur.getFloat(6);
                    area=mCur.getString(7);


                    System.out.println(mCur.getString(2));
                    helper.insertColumn(id,name,image,addr,x,y,code,area);


                    }

                    helper1.deleteAllColumns();

                    i[0]++;
                    System.out.println(i);
                    SharedPreferences.Editor editor = sroot1.edit();
                    editor.putInt("code", ++code);
                    editor.commit();
                Intent start_intent = new Intent(final_route_3.this, MainActivity.class);
                startActivity(start_intent);

            }

        }});

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

        mCur=helper1.sortColumn2();
        int id = R.drawable.no_camera;
        // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!

        if (mCur != null&& mCur.moveToFirst() ){
            System.out.println(mCur);
            list.add(mCur.getString(2));
            list.add("-");
            root_place.setText(mCur.getString(7));
            if (mCur.getString(3) != null) {
                Glide.with(final_route_3.this).load(mCur.getString(3)).into(root_picture);
            } else {root_picture.setImageResource(id);
            }}
            while(mCur.moveToNext()){
                list.add(mCur.getString(2));

                if(mCur.isLast()!=true){
                    list.add("-");
                }

            }


            root_1.setText(TextUtils.join(" ", list));


    }
}