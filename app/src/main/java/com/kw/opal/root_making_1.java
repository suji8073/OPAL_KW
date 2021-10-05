package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private ListView listView;
    private UserListAdapter adapter;
    final RetrofitService networkService = RetrofitHelper.create();



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sroot=getSharedPreferences("root",Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        final PostClass post = new PostClass("city",area,"A0201"); //intent로 인자 넘겨받아야함
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