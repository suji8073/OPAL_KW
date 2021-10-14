package com.kw.opal;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView home1, heart_1, heart_2;
    TextView home2;
    Button play;
    TextView user_name_main, main_1_name, main_2_name, main_1_root, main_2_root;

    String strNickname, strProfile;
    int login_check;
    boolean i, j = true;

    private SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbOpenHelper mDbOpenHelper;
        mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();


        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        Intent intent = getIntent();
        login_check = intent.getIntExtra("login_check", 4);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("login_check", login_check);
        editor.commit();

        Log.d("API 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("API 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("API 확인", "profile image: " + sp.getString("strProfile", ""));

        user_name_main = findViewById(R.id.user_name_main);



        if (login_check == 0){
            Toast.makeText(getApplicationContext(), "비회원으로 로그인하셨습니다!",
                    Toast.LENGTH_SHORT).show();
        }
        else if (login_check == 1){
            Toast.makeText(getApplicationContext(), "로그인 되셨습니다!",
                    Toast.LENGTH_SHORT).show();

            strNickname = intent.getStringExtra("name");
            strProfile = intent.getStringExtra("profile");

            editor.putString("strNickname", strNickname);
            editor.putString("strProfile", strProfile);
            editor.commit();

        }

        play = findViewById(R.id.play);

        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);

        home1 = findViewById(R.id.home1);
        home2 = findViewById(R.id.home2);

        final String strNickname = sp.getString("strNickname", "");
        if (strNickname != "") user_name_main.setText("\"" + strNickname+ "\" 님");
        else user_name_main.setText("\"" + "비회원"+ "\" 님");


        home1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        home2.setTextColor(getApplication().getResources().getColor(R.color.main));

        heart_1 = findViewById(R.id.heart_1);
        heart_2 = findViewById(R.id.heart_2);

        heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));


        main_1_name = findViewById(R.id.main_1_name);
        main_1_root = findViewById(R.id.main_1_root);
        main_2_name = findViewById(R.id.main_2_name);
        main_2_root = findViewById(R.id.main_2_root);

       //추천코스 넣기

        this.InitializeView();
        this.setTextView();



        heart_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    heart_1.setImageResource(R.drawable.heart_on);
                    Toast.makeText(getApplicationContext(), "나의 경로에 담겼습니다!",
                            Toast.LENGTH_SHORT).show();
                    heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    i = false;
                    editor.putString("main_1_name", String.valueOf(main_1_name));
                    editor.putString("main_1_root", String.valueOf(main_1_root));

                    ContentValues values = new ContentValues();
                    values.put("txt", String.valueOf(main_1_name));
                    values.put("txt", String.valueOf(main_1_root));
                    System.out.println(String.valueOf(main_1_name));

                    editor.commit();
                }else {
                    heart_1.setImageResource(R.drawable.heart_off);
                    heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    i = true;
                }

            }
        });


        heart_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (j == true){
                    heart_2.setImageResource(R.drawable.heart_on);
                    Toast.makeText(getApplicationContext(), "나의 경로에 담겼습니다!", Toast.LENGTH_SHORT).show();
                    heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    j = false;
                }else {
                    heart_2.setImageResource(R.drawable.heart_off);
                    heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    j = true;
                }

            }
        });


        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity.this, MainActivity_2.class);
                if (login_check == 0){
                    main_1.putExtra("name", "");
                    main_1.putExtra("profile", "");

                }
                else if (login_check == 1){
                    main_1.putExtra("name", strNickname);
                    main_1.putExtra("profile", strProfile);
                }
                startActivity(main_1);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity.this, MainActivity_3.class);
                if (login_check == 0){
                    main_1.putExtra("name", "");
                    main_1.putExtra("profile", "");

                }
                else if (login_check == 1){
                    main_1.putExtra("name", strNickname);
                    main_1.putExtra("profile", strProfile);
                }
                startActivity(main_1);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(MainActivity.this, area.class);
                startActivity(start_intent);
            }
        });


    }

    private void setTextView() {

        int[] category = {R.string.recommend1,R.string.recommend2,R.string.recommend3,R.string.recommend4,
                R.string.recommend5};
        int[] category1={R.string.recommend6,R.string.recommend7,R.string.recommend8,R.string.recommend9,
                R.string.recommend10};

        ArrayList<Integer> cards = new ArrayList<Integer>();
        ArrayList<Integer> cards2 = new ArrayList<Integer>();

        for (int i = 0; i < category.length; i++){
            cards.add(category[i]);
            cards2.add(category1[i]);
        }

        double randomValue = Math.random();
        int ran ;
        ran=(int)(randomValue * (cards.size()-1));
        Integer get_Card = cards.get(ran);
        cards.remove(ran);

        // shuffle 이
        Collections.shuffle(cards2);
        Integer get_Card2 = cards2.get(0);

        cards.remove(0);
        System.out.println(get_Card2);
        String a=getString(get_Card);
        String b=getString(get_Card2);
        System.out.println(a);
        String getStr[]= a.split("/");
        String getStr2[]= b.split("/");

        main_1_name.setText(getStr[0]);
        main_1_root.setText(getStr[1]);
        main_2_name.setText(getStr2[0]);
        main_2_root.setText(getStr2[1]);
    }

    private void InitializeView() {
        main_1_name = findViewById(R.id.main_1_name);
        main_1_root = findViewById(R.id.main_1_root);
        main_2_name = findViewById(R.id.main_2_name);
        main_2_root = findViewById(R.id.main_2_root);

    }


}