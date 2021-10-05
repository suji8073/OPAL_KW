package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.usermgmt.response.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class root_making_1 extends AppCompatActivity {
    private SharedPreferences sroot;
    private ListView listView1;
    private UserListAdapter adapter1;
    final RetrofitService networkService = RetrofitHelper.create();
    Button finish;
    ImageView cart;

    Button finish;
    ImageView cart;


    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sroot=getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        final PostClass post = new PostClass("city",area,"A0201"); //todo 카테고리 전체 불러올떈 sql인젝션으로 카테고리 구분 없이 처리

        networkService.setPostBody(post)
                .enqueue(new Callback<PointList>() {
                    @Override

                    public void onResponse(Call<PointList> call, Response<PointList> response) {
                        if(response.isSuccessful()){

                            List point = response.body().pointlist;
                            ArrayList<PointModel> array = new ArrayList<>();
                            array.addAll(point);
                            Log.d("test",point.toString());
                            setContentView(R.layout.root_making_1);
                            //Intent intent = getIntent();
                            Log.d("test",array.get(0).toString());
                            adapter1 = new UserListAdapter(getApplicationContext(), array);
                            listView1 = (ListView) findViewById(R.id.userListTextView1);
                            listView1.setAdapter(adapter1);
                            finish = findViewById(R.id.finish1);
                            finish.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent start_intent = new Intent(getApplicationContext(), root_make.class);
                                    startActivity(start_intent);
                                }
                            });
                            cart = findViewById(R.id.cart);
                            cart.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent start_intent = new Intent(getApplicationContext(), final_route_1.class);
                                    start_intent.putExtra("check", 0);
                                    startActivity(start_intent);
                                }
                            });

                        }
                    }
                    @Override
                    public void onFailure(Call<PointList> call, Throwable t) {
                        Log.d("test",t.toString());
                    }
                });




    }
}