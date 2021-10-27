package com.kw.opal;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class random_1 extends AppCompatActivity {
    SingerAdapter adapter;


    LinearLayout reset;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_1);


        GridView gridView = (GridView) findViewById(R.id.gridview);
        adapter = new SingerAdapter();
        //TODO 여기 item에 하나씩 넣으면 됨여 랜덤

        adapter.addItem(new SingerItem("소녀시대",  R.drawable.click));
        adapter.addItem(new SingerItem("빅뱅",  R.drawable.click));
        adapter.addItem(new SingerItem("김주현",  R.drawable.click));
        adapter.addItem(new SingerItem("ㅇㅇ",  R.drawable.click));
        adapter.addItem(new SingerItem("하하",  R.drawable.click));
        adapter.addItem(new SingerItem("호호",  R.drawable.click));
        gridView.setAdapter(adapter);

        System.out.println("ss");


        reset = findViewById(R.id.reset); //리셋버튼




    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        Context context;

        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            SingerItemView view = null;
            if (convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(position);

            view.setName(item.getName());
            view.setImage(item.getResId());


            return view;
        }
    }

}

