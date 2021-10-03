package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loading extends AppCompatActivity {
    String strNickname, strProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        SharedPreferences sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);

        String strNickname = sp.getString("strNickname", "");

        Log.d("M3 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("M3 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("M3 확인", "profile image: " + sp.getString("strProfile", ""));

        if (strNickname.length() > 0){
            startLoading();
        }
        else {
            startLoading();
        }



    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    private void skipLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("login_check", 1);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
