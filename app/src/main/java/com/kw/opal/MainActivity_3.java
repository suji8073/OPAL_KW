package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity_3 extends AppCompatActivity {
    LinearLayout home, place;
    ImageView person1, user_Profile;
    TextView person2, user_Name;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        sp = getSharedPreferences("myFile", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        int login_check = sp.getInt("login_check", 0);
        String strNickname = sp.getString("strNickname", "");
        String strProfile = sp.getString("strProfile", "");


        home = findViewById(R.id.home);
        place = findViewById(R.id.place);

        user_Profile = findViewById(R.id.user_Profile);
        user_Name = findViewById(R.id.user_Name);

        new DownloadFilesTask().execute(strProfile);

        Log.d("M3 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("M3 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("M3 확인", "profile image: " + sp.getString("strProfile", ""));

        user_Name.setText(strNickname);
        person1 = findViewById(R.id.person1);
        person2 = findViewById(R.id.person2);

        person1.setColorFilter(getApplication().getResources().getColor(R.color.main));
        person2.setTextColor(getApplication().getResources().getColor(R.color.main));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_3.this, com.kw.opal.MainActivity.class);
                main_1.putExtra("login_check", 3);
                startActivity(main_1);
            }
        });

        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(MainActivity_3.this, MainActivity_2.class);
                main_1.putExtra("login_check", 3);
                startActivity(main_1);
            }
        });


    }
    private class DownloadFilesTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            user_Profile.setImageBitmap(result);
        }
    }
}