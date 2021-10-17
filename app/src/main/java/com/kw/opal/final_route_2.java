package com.kw.opal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class final_route_2 extends AppCompatActivity {


    private DbOpenHelper helper;

    static ArrayList<TabItem> arrayData = new ArrayList<TabItem>();
    static ArrayList<TabItem> arrayIndex =  new ArrayList<TabItem>();
    ArrayList<TabItem> items = new ArrayList<TabItem>();
    Button next;
    ImageView circle1, circle2, circle3;
    int check;
    private TabListAdapter mAdapter=new TabListAdapter();
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_route_2);
        helper = new DbOpenHelper(final_route_2.this);

        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        Set<String> area = pref.getStringSet("pref",null);
        if( area != null)
        {
            for(Object lst:area)
            {
                Log.d("간다", lst.toString());
            }
        }
        String sort = "_id";


        Intent intent = getIntent();
        check = intent.getIntExtra("check", 0);

        final Context mContext;



        next = findViewById(R.id.next);
        if (check == 0){
            next.setText("이 전");
        }
        else {
            next.setText("다 음");
        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_tab_list);


        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new TabListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mAdapter));

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        //TextView name = (TextView)v.findViewById(R.id.name);





        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        circle1.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        showDatabase();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == 0){
                    finish();
                }
                else {
                    Intent start_intent = new Intent(final_route_2.this, final_route_3.class);
                    startActivity(start_intent);
                }
            }
        });


    }


    public void showDatabase(){


        Cursor mCur = helper.sortColumn("name");
        System.out.println(mCur);
        Log.d("showDatabase", "DB Size: " + mCur.getCount());
        arrayData.clear();
        arrayIndex.clear();


        // 칼럼의 마지막까지
        while( mCur.moveToNext() ) {

            // TODO : 커스텀 모델 생성
            TabItem user = new TabItem();

            // TODO : Record 기술
            // id, name, account, privateKey, secretKey, Comment

            user.setName(mCur.getString(2));
            user.setNumber(mCur.getInt(1));
            user.setImage(mCur.getString(3));

            // 리스트에 넣기
            System.out.println(mCur.getString(2));
            System.out.println(mCur.getString(3));

            items.add(user);
            System.out.println(items);


        }
        System.out.println(items);
        mAdapter.setItems(items);

    }

    public String setTextLength(String text, int length){
        if(text.length()<length){
            int gap = length - text.length();
            for (int i=0; i<gap; i++){
                text = text + " ";
            }
        }
        return text;
    }


}