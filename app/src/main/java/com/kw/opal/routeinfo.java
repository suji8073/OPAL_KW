package com.kw.opal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class routeinfo extends AppCompatActivity {
    UserListAdapter2 adapter;

    final RSinterface networkService = RetrofitHelper.create();
    ListView listView;
    TextView title;
    Button fin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String contentId = getIntent().getStringExtra("Id");
        String name = getIntent().getStringExtra("Name");
        RouteinfoClass post = new RouteinfoClass(contentId);
        Call<PointList> call= networkService.getRouteInfo(post);


        call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    setContentView(R.layout.route_inform);
                    title = findViewById(R.id.root_name);
                    title.setText(name);
                    adapter = new UserListAdapter2(getApplicationContext(), array);
                    listView = (ListView) findViewById(R.id.userlistadapter);
                    listView.setAdapter(adapter);
                    fin =findViewById(R.id.smart_root_check);
                    fin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //TODO 주현아 여기다가 array(타입 ArrayList<PointModel>) 안에 있는거 전부 장바구니에 넣고 intent로 파이널로 바로 넘어가면 댐



                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<PointList> call, Throwable t) {
                //TODO 인터넷 연결 관련 팝업창 띄우기

            }
        });

    }
}
