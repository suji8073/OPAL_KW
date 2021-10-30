package com.kw.opal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class routeinfo extends AppCompatActivity {
    UserListAdapter2 adapter;
    DbOpenHelper helper ;
    Context context;
    Integer id1;
    String one, two, three, four;
    Set<String> set = new HashSet<String>();
    List<PointModel> point;
    String area_name;
    SharedPreferences sroot;
    final RSinterface networkService = RetrofitHelper.create();
    ListView listView;
    TextView title;
    Button fin;
    int position;


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
                    point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    setContentView(R.layout.route_inform);
                    title = findViewById(R.id.root_name);
                    title.setText(name);
                    adapter = new UserListAdapter2(getApplicationContext(), array);
                    listView = (ListView) findViewById(R.id.userlistadapter);
                    listView.setAdapter(adapter);
                    fin =findViewById(R.id.smart_root_check);
                    System.out.println(point.size());
                    fin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            position=0;
                            helper = new DbOpenHelper(getApplicationContext());

                            System.out.println("db가 열렸어");
                            for(int i=0;i<array.size();i++){
                                sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
                                area_name = sroot.getString("area_name", "");
                                //TODO 주현아 여기다가 array(타입 ArrayList<PointModel>) 안에 있는거 전부 장바구니에 넣고 intent로 파이널로 바로 넘어가면 댐
                                id1=Integer.valueOf(array.get(i).getId());
                                one = String.valueOf(array.get(i).getName());
                                two = String.valueOf(array.get(i).getAddr());
                                three = String.valueOf(array.get(i).getImage());
                                Float x = Float.valueOf(array.get(i).getMap_x());
                                Float y = Float.valueOf(array.get(i).getMap_y());
                                String typeid=String.valueOf(point.get(i).getContentTypeId());
                                helper.open();
                                helper.insertColumn(id1, one, three,two,x,y,area_name,typeid);//area name 추가
                            }
                            Intent finish_root = new Intent(getApplicationContext(), final_route_2.class);
                            finish_root.putExtra("check", 1);
                            startActivity(finish_root);

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
