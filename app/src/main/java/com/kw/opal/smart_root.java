package com.kw.opal;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class smart_root extends AppCompatActivity {

    Button smart_root_check, smart_root_no;

    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_root);
        ListView listView = (ListView) findViewById(R.id.smart_root);
        adapter = new SingerAdapter();
        //TODO 여기 item에 하나씩 넣으면 됨여 랜덤
        adapter.addItem(new SingerItem1("주현이는", "지각쟁이"));

        listView.setAdapter(adapter);
        smart_root_check = findViewById(R.id.smart_root_check); // 선택하기 버튼
        smart_root_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        smart_root_no = findViewById(R.id.smart_root_no); // 취소하기 버튼
        smart_root_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<SingerItem1> items = new ArrayList<SingerItem1>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem1 item) {
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

            SingerItemView1 view = null;
            if (convertView == null) {
                view = new SingerItemView1(getApplicationContext());

            } else {
                view = (SingerItemView1) convertView;
            }

            SingerItem1 item = items.get(position);
            ImageView check = (ImageView) view.findViewById(R.id.smart_check); //하트
            check.setImageResource(R.drawable.check_off);
            check.setColorFilter(view.getResources().getColor(R.color.gray));

            view.setName(item.getName());
            view.setMobile(item.getMobile());



            return view;
        }
    }
}