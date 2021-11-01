package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class new_MainActivity_2 extends AppCompatActivity {

    SingerAdapter adapter;
    ArrayList<RouteModel> Rlist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    LinearLayout home, place, person;
    public SharedPreferences sroot,curcode;
    int root_num = 0;
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    reDBOpenHelper helper;
    Cursor mCur;
    Context context;
    Cursor mCur1;
    String img;

    int code;
    int cnt = 0;
    int next_page = 0;
    int incurcode;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmain2);

        helper = new reDBOpenHelper(new_MainActivity_2.this);
        mCur1=helper.sortColumn();
        adapter = new SingerAdapter();

        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        curcode= getSharedPreferences("code", Activity.MODE_PRIVATE);
        incurcode=curcode.getInt("code",0);


        ListView listView = (ListView) findViewById(R.id.smart_root);

        home = findViewById(R.id.home);
        place = findViewById(R.id.place);
        person = findViewById(R.id.person);
        if (incurcode>0){
            for(int i=0;i<incurcode;i++){
                /*if (i==1)
                    continue;*/

                mCur=helper.selectC(String.valueOf(i));
                System.out.println(mCur);
                mCur.moveToFirst();
                int id = R.drawable.no_camera;
                // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                if (!isBlank(mCur.getString(3)) ) {
                    img=mCur.getString(3);
                }
                else {img="";}
                mCur.moveToFirst();
                if (mCur != null&& mCur.moveToFirst() ) {
                    System.out.println(mCur.getString(1));
                    list.add(mCur.getString(2));
                    list.add("-");
                    while (mCur.moveToNext()) {
                        list.add(mCur.getString(2));

                        if (mCur.isLast() != true) {
                            list.add("-");
                        }
                    }
                }
                System.out.println(mCur);

                String title=TextUtils.join(" ", list);
                RouteModel r=new RouteModel(String.valueOf(i),title,img);
                Rlist.add(r);
                list.clear();
            }
            adapter.addItem(Rlist);
            listView.setAdapter(adapter);
        }

        adapter = new SingerAdapter();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(new_MainActivity_2.this, com.kw.opal.MainActivity.class);
                startActivity(main_1);
            }
        });

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_1 = new Intent(new_MainActivity_2.this, com.kw.opal.MainActivity_3.class);
                startActivity(main_1);
            }
        });



    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<RouteModel> items = new ArrayList<RouteModel>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ArrayList<RouteModel> item) {
            items.addAll(item);
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

            SingerItemView2 view = null;
            if (convertView == null) {
                view = new SingerItemView2(getApplicationContext());

            } else {
                view = (SingerItemView2) convertView;
            }

            RouteModel item = items.get(position);
            view.setmodel(item);




            return view;
        }
    }



}