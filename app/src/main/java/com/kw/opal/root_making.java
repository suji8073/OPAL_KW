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
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class root_making extends AppCompatActivity {
    //새로 정의 해야 하는 부분
    int layout;
    int userview ;
    int cartv ;
    int finishv;
    String table;
    ArrayList<String> catlist;
    Integer[] category;
    Button[] c_one;

    //이하는 공통사용
    SharedPreferences sroot;
    SharedPreferences pref;
    ListView listView;
    UserListAdapter adapter;
    Button finish;
    ImageView cart;

    int[] on_off = new int[]{1, 0, 0, 0, 0};
    int one_pick = 1;

    final RSinterface networkService = RetrofitHelper.create();



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        final WPClass post = new WPClass(table,area,"all"); //todo 카테고리 검색은 여기다 catlist넣어서
        networkService.getPoint(post)
                .enqueue(new Callback<PointList>() {
                    @Override

                    public void onResponse(Call<PointList> call, Response<PointList> response) {
                        if(response.isSuccessful()){

                            List point = response.body().pointlist;
                            ArrayList<PointModel> array = new ArrayList<>();
                            array.addAll(point);
                            setContentView(layout);
                            //Intent intent = getIntent();


                            adapter = new UserListAdapter(getApplicationContext(), array);
                            listView = (ListView) findViewById(userview);
                            listView.setAdapter(adapter);

                            // 값 불러오기

                            pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
                            int position = pref.getInt("count", -1);
                            Log.d("하트 누른거 뜨는거야 알겠지?", String.valueOf(position));




                            for (int i=0; i<c_one.length; i++){ // 카테고리 형 변환
                                c_one[i] = findViewById(category[i]);
                            }

                            for (int i=0; i<c_one.length; i++){
                                final int INDEX;
                                INDEX = i;


                                c_one[INDEX].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        int re = check_on_off(INDEX); // 체크 되었는지 표시
                                        if (re == 0){ // 이미 체크된 것임
                                            c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                            c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.black));
                                        }
                                        else if (re == 1){ // 전에 체크 되지 않은 것
                                            c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                                            c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                                        }
                                        else if (re == 2){ // 하나 이상 체크하려고 하는 경우
                                            for (int i=0; i<on_off.length; i++){
                                                if (on_off[i] == 1){
                                                    c_one[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                                    c_one[i].setTextColor(getApplication().getResources().getColor(R.color.black));
                                                    on_off[i] = 0;
                                                }
                                            }
                                            c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                                            c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                                            on_off[INDEX] = 1;

                                        }

                                    }
                                });
                            }


                            finish = findViewById(finishv);
                            finish.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent start_intent = new Intent(getApplicationContext(), root_make.class);
                                    startActivity(start_intent);
                                }
                            });
                            cart = findViewById(cartv);
                            cart.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent start_intent = new Intent(getApplicationContext(), final_route_2.class);
                                    start_intent.putExtra("check", 0);
                                    startActivity(start_intent);
                                }
                            });

                        }
                    }
                    @Override
                    public void onFailure(Call<PointList> call, Throwable t) {

                    }
                });

    }
    public int check_on_off(int index) { // 체크 되었는지 확인
        for (int i=0; i<c_one.length; i++){
            if (on_off[i] == 1){ //체크 된 것
                if (index == i) { //체크 된 것과 내가 클릭한 것이 같으면 다시 체크안 된 것으로
                    on_off[i] = 0;
                    one_pick -= 1;
                    return 0;
                }
            }
        }
        if (one_pick == 1){
            return 2;
        }
        // 전에 체크 되지 않은 것
        on_off[index] = 1;
        one_pick += 1;
        return 1;
    }
}
