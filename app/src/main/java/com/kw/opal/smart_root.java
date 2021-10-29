package com.kw.opal;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class smart_root extends AppCompatActivity { //이게 걍 미리 제공되어진 경로

    Button smart_root_check, smart_root_no;
    final RSinterface networkService = RetrofitHelper.create();
    SingerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_root);
        ListView listView = (ListView) findViewById(R.id.smart_root);
        SharedPreferences sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        adapter = new SingerAdapter();
        //TODO 여기 item에 하나씩 넣으면 됨여 랜덤


        RouteClass post = new RouteClass(area,"all","F");
        Log.d("test",post.toString());
        Call<RouteList> call= networkService.getRoute(post);
        call.enqueue(new Callback<RouteList>() {
            @Override
            public void onResponse(Call<RouteList> call, Response<RouteList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<RouteModel> array = new ArrayList<>();
                    array.addAll(point);
                    adapter.addItem(array);
                    listView.setAdapter(adapter);

                }
            }
            @Override
            public void onFailure(Call<RouteList> call, Throwable t) {
                //TODO 인터넷 연결 관련 팝업창 띄우기

            }
        });
        //adapter.addItem(RouteModel);


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


            SingerItemView1 view = null;
            if (convertView == null) {
                view = new SingerItemView1(getApplicationContext());

            } else {
                view = (SingerItemView1) convertView;
            }

            RouteModel item = items.get(position);
            view.setmodel(item);




            return view;
        }
    }
}