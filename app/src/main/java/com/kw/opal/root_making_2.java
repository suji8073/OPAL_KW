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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class root_making_2 extends AppCompatActivity {

    private SharedPreferences sroot;
    private ListView listView2;
    private UserListAdapter adapter2;
    final RSinterface networkService = RetrofitHelper.create();
    Button finish;
    ImageView cart;

    Integer[] category2 = {R.id.one_1, R.id.one_2, R.id.one_3, R.id.one_4};
    Button[] c_one2 = new Button[4];
    int[] on_off2 = new int[]{1, 0, 0, 0};
    int one_pick2 = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sroot=getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        final WPClass post = new WPClass("food",area,"A05020100"); //intent로 인자 넘겨받아야함
        networkService.getPoint(post)
                .enqueue(new Callback<PointList>() {
                    @Override

                    public void onResponse(Call<PointList> call, Response<PointList> response) {
                        if(response.isSuccessful()){

                            List point = response.body().pointlist;
                            ArrayList<PointModel> array = new ArrayList<>();
                            array.addAll(point);
                            Log.d("test",point.toString());
                            setContentView(R.layout.root_making_2);
                            //Intent intent = getIntent();
                            Log.d("test",array.get(0).toString());
                            adapter2 = new UserListAdapter(getApplicationContext(), array);
                            listView2 = (ListView) findViewById(R.id.userListTextView2);
                            listView2.setAdapter(adapter2);

                            for (int i=0; i<c_one2.length; i++){ // 카테고리 형 변환
                                c_one2[i] = findViewById(category2[i]);
                            }

                            for (int i=0; i<c_one2.length; i++){
                                final int INDEX;
                                INDEX = i;

                                c_one2[INDEX].setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        int re = check_on_off(INDEX); // 체크 되었는지 표시
                                        if (re == 0){ // 이미 체크된 것임
                                            c_one2[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                            c_one2[INDEX].setTextColor(getApplication().getResources().getColor(R.color.black));
                                        }
                                        else if (re == 1){ // 전에 체크 되지 않은 것
                                            c_one2[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                                            c_one2[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                                        }
                                        else if (re == 2){ // 하나 이상 체크하려고 하는 경우
                                            for (int i=0; i<on_off2.length; i++){
                                                if (on_off2[i] == 1){
                                                    c_one2[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                                    c_one2[i].setTextColor(getApplication().getResources().getColor(R.color.black));
                                                    on_off2[i] = 0;
                                                }
                                            }
                                            c_one2[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                                            c_one2[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                                            on_off2[INDEX] = 1;

                                        }

                                    }
                                });
                            }


                            finish = findViewById(R.id.finish2);
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

                        }
                    }
                    @Override
                    public void onFailure(Call<PointList> call, Throwable t) {
                        Log.d("test",t.toString());
                    }
                });

    }
    public int check_on_off(int index) { // 체크 되었는지 확인
        for (int i=0; i<c_one2.length; i++){
            if (on_off2[i] == 1){ //체크 된 것
                if (index == i) { //체크 된 것과 내가 클릭한 것이 같으면 다시 체크안 된 것으로
                    on_off2[i] = 0;
                    one_pick2 -= 1;
                    return 0;
                }
            }
        }
        if (one_pick2 == 1){
            return 2;
        }
        // 전에 체크 되지 않은 것
        on_off2[index] = 1;
        one_pick2 += 1;
        return 1;
    }
}
