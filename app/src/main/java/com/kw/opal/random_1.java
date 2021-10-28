package com.kw.opal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class random_1 extends AppCompatActivity {
    SingerAdapter adapter;
    LinearLayout reset;
    Button SB;
    EditText ST;
    final RSinterface networkService = RetrofitHelper.create();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getdata();
        //리셋버튼 내부 아이템을 편집해야함. 아니면 전부 제거하고 새로 하던가.




    }
    public void getdata(){
        SharedPreferences sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        WPClass post = new WPClass("city",area,"all","random");
        Log.d("test",post.toString());
        Call<PointList> call= networkService.getPoint(post);
        call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    setContentView(R.layout.random_1);
                    GridView gridView = (GridView) findViewById(R.id.gridview);
                    adapter = new SingerAdapter();
                    //TODO 여기 item에 하나씩 넣으면 됨여 랜덤
                    for (int i=0;i<6;i++){
                        adapter.addPoint(array.get(i));
                    }
                    gridView.setAdapter(adapter);
                    reset = (LinearLayout)findViewById(R.id.reset);
                    reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            adapter.items.clear();
                            getdata();
                        }
                    });
                    SB=findViewById(R.id.search_button);
                    ST=findViewById(R.id.editText);

                    SB.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            InputMethodManager mInputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            SearchClass sc = new SearchClass("city",area,ST.getText().toString());
                            Call<PointList> call= networkService.searchPoint(sc);
                            call.enqueue(new Callback<PointList>() {
                                             @Override
                                             public void onResponse(Call<PointList> call, Response<PointList> response) {
                                                 try {
                                                     List point = response.body().pointlist;
                                                     ArrayList<PointModel> array = new ArrayList<>();
                                                     array.addAll(point);
                                                     adapter.items.clear();
                                                     if (array.size()>6){
                                                         for (int i=0;i<6;i++){
                                                             adapter.addPoint(array.get(i));
                                                         }
                                                     }
                                                     else{
                                                         for (int i=0;i<array.size();i++){
                                                             adapter.addPoint(array.get(i));
                                                         }
                                                     }
                                                     gridView.setAdapter(adapter);
                                                     ST.setText(null);
                                                     mInputMethodManager.hideSoftInputFromWindow(ST.getWindowToken(), 0);

                                                 }
                                                 catch (NullPointerException n){
                                                     //검색결과 없음
                                                     mInputMethodManager.hideSoftInputFromWindow(ST.getWindowToken(), 0);
                                                     ST.setText(null);
                                                 }
                                             }

                                             @Override
                                             public void onFailure(Call<PointList> call, Throwable t) {
                                                 //TODO 네트워크 오류 관련 추가

                                             }
                                         }


                            );
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
    class SingerAdapter extends BaseAdapter {
        ArrayList<PointModel> items = new ArrayList<PointModel>();
        Context context;

        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addPoint(PointModel pm) {
            items.add(pm);
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
            SingerItemView view = null;
            if (convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            view.setPoint(items.get(position));



            return view;
        }
    }

}

