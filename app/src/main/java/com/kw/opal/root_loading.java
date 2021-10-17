package com.kw.opal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class root_loading extends AppCompatActivity {
    ImageView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_loading);

        setting = (findViewById(R.id.setting));
        setting.setColorFilter(getApplication().getResources().getColor(R.color.main));
        startLoading();
    }
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start_intent = new Intent(getApplicationContext(), random_3_play.class);
                startActivity(start_intent);
                finish();
            }
        }, 2000);
    }
}
