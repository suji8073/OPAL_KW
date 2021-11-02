package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity_F3 extends Fragment {
    LinearLayout home, place;
    ImageView person1, user_Profile;
    TextView person2, user_Name;
    private SharedPreferences sp;
    String strNickname;
    int login_check;
    String strProfile;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sp = this.getActivity().getSharedPreferences("myFile", Activity.MODE_PRIVATE);
        login_check = sp.getInt("login_check", 0);
        strNickname = sp.getString("strNickname", "");
        strProfile = sp.getString("strProfile", "");
        View v= inflater.inflate(R.layout.newmain3_f, container, false);
        user_Profile = v.findViewById(R.id.user_Profile);
        user_Name = v.findViewById(R.id.user_Name);
        if (!isBlank(strNickname))
            user_Name.setText(strNickname + "님");
        else
            user_Name.setText("\"" + "비회원"+ "\" 님");
        return v;
    }


    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences.Editor editor = sp.edit();


        new DownloadFilesTask().execute(strProfile);



        Log.d("M3 확인", "login_check: " + sp.getInt("login_check", 0));
        Log.d("M3 확인", "nickname: " + sp.getString("strNickname", ""));
        Log.d("M3 확인", "profile image: " + sp.getString("strProfile", ""));






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
            if (result == null){
                user_Profile.setImageResource(R.drawable.no_camera);
            }
            else{
                user_Profile.setImageBitmap(result);
            }



        }
    }
}
