package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.*;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivityAll extends AppCompatActivity {
    LinearLayout[] Linear = new LinearLayout[3];

    ViewPager2 viewPager =null;
    LinearLayout home, place, person;
    int p=0;
    int v=1;
    DbOpenHelper mDbOpenHelper;
    rootDBOpenHelper rmDbOpenHelper;
    reDBOpenHelper rDbOpenHelper;
    TextView user_name_main, main_1_name, main_2_name, main_1_root, main_2_root;
    String strNickname, strProfile;
    int login_check;
    boolean i, j;
    Handler handler=null;
    Thread thread=null;
    PagerAdapter pagerAdapter;
    ImageView home1,place1,person1;
    TextView home2,place2,person2;
    ImageView[] mbutton=new ImageView[3];
    TextView[] mbtext=new TextView[3];
    int where;


    private SharedPreferences sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_activity_main);
        Intent intent2 = getIntent();
        where= intent2.getIntExtra("to", 0);

        mDbOpenHelper = new DbOpenHelper(this); //TODO 얘네는 옮기기 저 위로
        mDbOpenHelper.open();
        mDbOpenHelper.create();


        rmDbOpenHelper = new rootDBOpenHelper(this);
        rmDbOpenHelper.open();
        rmDbOpenHelper.create();


        rDbOpenHelper = new reDBOpenHelper(this);
        rDbOpenHelper.open();
        rDbOpenHelper.create();

        user_name_main = findViewById(R.id.user_name_main);
        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);
        Linear[0] =home;
        Linear[1] =place;
        Linear[2] =person;
        home1 = findViewById(R.id.home1);
        home2 = findViewById(R.id.home2);
        place1 = findViewById(R.id.place1);
        place2 = findViewById(R.id.place2);
        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);
        mbutton[0]=home1;
        mbutton[1]=place1;
        mbutton[2]=person1;
        mbtext[0]=home2;
        mbtext[1]=place2;
        mbtext[2]=person2;


        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        Intent intent = this.getIntent();
        login_check = intent.getIntExtra("login_check", 4);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("login_check", login_check);
        editor.commit();


        if (login_check == 0){
            Toast.makeText(this, "비회원으로 로그인하셨습니다!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (login_check == 1){
            Toast.makeText(this, "로그인 되셨습니다!",
                    Toast.LENGTH_SHORT).show();

            strNickname = intent.getStringExtra("name");
            strProfile = intent.getStringExtra("profile");

            editor.putString("strNickname", strNickname);
            editor.putString("strProfile", strProfile);
            editor.commit();

        }
        viewPager=findViewById(R.id.viewpager);
        pagerAdapter = new PagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);




        Linear[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                viewPager.setCurrentItem(0);

            }

        });

        Linear[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }

        });

        Linear[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);

            }
        });

        viewPager.registerOnPageChangeCallback(callback);
        if(where!=0)
            viewPager.setCurrentItem(where);






    }
    private ViewPager2.OnPageChangeCallback callback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int pos) {
            super.onPageSelected(pos);
            for (int i=0;i<3;i++){
                if (i==pos) {
                    mbutton[pos].setColorFilter(Color.parseColor("#3A4CA8"));
                    mbtext[pos].setTextColor(Color.parseColor("#3A4CA8"));
                }
                else {
                    mbutton[i].setColorFilter(Color.parseColor("#000000"));
                    mbtext[i].setTextColor(Color.parseColor("#000000"));
                }
            }
        }
    };

    private class PagerAdapter extends FragmentStateAdapter {
        Fragment[] fragments = new Fragment[3];

        public PagerAdapter(FragmentActivity fm) {
            super(fm);
            fragments[0] = new MainActivity_F1();
            fragments[1] = new MainActivity_F2();
            fragments[2] = new MainActivity_F3();
        }

        @Override
        public Fragment createFragment(int position) {

            return fragments[position];
        }

        @Override
        public int getItemCount() {
            return fragments.length;
        }
    }
}
