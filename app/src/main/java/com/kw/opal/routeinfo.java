package com.kw.opal;

import android.app.Activity;
import android.content.Context;
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
    public routeinfo(Context context, List<PointModel> pointList) {
        this.context = context;
        this.point = pointList;

    }
    public List getList(){
        return this.point;
    }


    public int getCount() {
        //현재사용자의 개수 반환
        return point.size();
    }
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
                            helper.open();
                            System.out.println("db가 열렸어");
                            while (position<point.size())
                                sroot = context.getSharedPreferences("root", Activity.MODE_PRIVATE);
                                area_name = sroot.getString("area_name", "");
                                //TODO 주현아 여기다가 array(타입 ArrayList<PointModel>) 안에 있는거 전부 장바구니에 넣고 intent로 파이널로 바로 넘어가면 댐
                                helper = new DbOpenHelper(context);
                                id1=Integer.valueOf(point.get(position).getId());
                                one = String.valueOf(point.get(position).getName());
                                two = String.valueOf(point.get(position).getAddr());
                                three = String.valueOf(point.get(position).getImage());
                                Float x = Float.valueOf(point.get(position).getMap_x());
                                Float y = Float.valueOf(point.get(position).getMap_y());
                                String typeid=String.valueOf(point.get(position).getContentTypeId());
                                System.out.println("끝ㅌㅌㅌ");
                                //set.addAll(Collections.singleton(String.valueOf(position)));



                                helper.insertColumn(id1, one, three,two,x,y,area_name,typeid);//area name 추가
                                position+=1;



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
