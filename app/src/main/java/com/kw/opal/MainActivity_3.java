package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class MainActivity_3 extends AppCompatActivity {
    LinearLayout home, place;
    ImageView person1, user_Profile;
    TextView person2, user_Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        SharedPreferences sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int login_check = sp.getInt("login_check", 0);
        String strNickname = sp.getString("strNickname", "");
        String strProfile = sp.getString("strProfile", "");


        home = findViewById(R.id.home);
        place = findViewById(R.id.place);

        user_Profile = findViewById(R.id.user_Profile);
        user_Name = findViewById(R.id.user_Name);
        Glide.with(getApplicationContext())
                .load(Uri.parse(strProfile))
                .placeholder(R.drawable.no_camera)
                .into(user_Profile);



        Log.d("M3 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("M3 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("M3 확인", "profile image: " + sp.getString("strProfile", ""));

        if (strNickname != "") user_Name.setText(strNickname + "님");
        else user_Name.setText("\"" + "비회원"+ "\" 님");

        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);

        person1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        person2.setTextColor(getApplication().getResources().getColor(R.color.main));

        home.setOnClickListener(view -> {
            Intent main_1 = new Intent(MainActivity_3.this, MainActivity.class);
            main_1.putExtra("login_check", 3);
            startActivity(main_1);
        });


        place.setOnClickListener(view -> {
            Intent main_1 = new Intent(MainActivity_3.this, MainActivity_2.class);
            main_1.putExtra("login_check", 3);
            startActivity(main_1);

        });


    }


}