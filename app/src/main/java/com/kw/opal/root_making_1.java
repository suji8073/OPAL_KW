package com.kw.opal;

import android.content.Intent;
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

    private ListView listView;
    private UserListAdapter adapter;
    private ArrayList<Local_user> userList;
    final RetrofitService networkService = RetrofitHelper.create();
    final PostClass post = new PostClass("city",2,"A0201"); //intent로 인자 넘겨받아야함

    Button finish;
    ImageView cart;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        finish = findViewById(R.id.finish);
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
                Intent start_intent = new Intent(getApplicationContext(), final_route_2.class);
                start_intent.putExtra("check", 0);
                startActivity(start_intent);
            }
        });


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
                            Intent intent = getIntent();
                            //초기화를 해줘야지 실행이된다
                            listView = (ListView) findViewById(R.id.userListTextView);


                            //어댑터 초기화부분 userList와 어댑터를 연결해준다.
                            adapter = new UserListAdapter(getApplicationContext(), array);
                            listView.setAdapter(adapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<PointList> call, Throwable t) {
                        Log.d("test",t.toString());
                    }
                });



    }

}