package com.kw.opal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class final_route_2 extends AppCompatActivity {

    Button next;
    ImageView circle1, circle2, circle3;
    int check;
    private RecyclerView mRecyclerView;
    private TabListAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;
    public SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_route_2);
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        Set<String> area = pref.getStringSet("pref",null);
        if( area != null)
        {
            for(Object lst:area)
            {
                Log.d("간다", lst.toString());
            }
        }

        Intent intent = getIntent();
        check = intent.getIntExtra("check", 0);

        next = findViewById(R.id.next);
        if (check == 0){
            next.setText("이 전");
        }
        else {
            next.setText("다 음");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_tab_list);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new TabListAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mAdapter));

        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        ArrayList<TabItem> items = new ArrayList<>();
        TabItem item1 = new TabItem("SUBSCRIBE",0);
        TabItem item2 = new TabItem("BEST",0);
        TabItem item3 = new TabItem("MUSIC",0);
        TabItem item4 = new TabItem("SPORTS",0);
        TabItem item5 = new TabItem("GAME",0);
        TabItem item6 = new TabItem("MUSIC",0);
        TabItem item7 = new TabItem("SPORTS",0);
        TabItem item8 = new TabItem("GAME",0);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);


        mAdapter.setItems(items);



        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);

        circle1.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));



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

}