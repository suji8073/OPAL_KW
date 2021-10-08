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
}