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

import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class MainActivity extends AppCompatActivity {
    LinearLayout home, place, person;
    ImageView home1, heart_1, heart_2;
    TextView home2;
    Button play;

    String strNickname, strProfile;
    int login_check;
    boolean i, j = true;

    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        Intent intent = getIntent();
        login_check = intent.getIntExtra("login_check", 4);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("login_check", login_check);
        editor.commit();

        Log.d("API 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("API 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("API 확인", "profile image: " + sp.getString("strProfile", ""));



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


        home1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        home2.setTextColor(getApplication().getResources().getColor(R.color.main));

        heart_1 = findViewById(R.id.heart_1);
        heart_2 = findViewById(R.id.heart_2);

        heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
        heart_2.setColorFilter(getApplication().getResources().getColor(R.color.heart));



        heart_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == true){
                    heart_1.setImageResource(R.drawable.heart_on);
                    Toast.makeText(getApplicationContext(), "나의 경로에 담겼습니다!",
                            Toast.LENGTH_SHORT).show();
                    heart_1.setColorFilter(getApplication().getResources().getColor(R.color.heart));
                    i = false;
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

}