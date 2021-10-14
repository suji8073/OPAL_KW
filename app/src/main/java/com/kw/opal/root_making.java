package com.kw.opal;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.squareup.otto.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.annotation.SuppressLint;
public class root_making extends AppCompatActivity {
    //새로 정의 해야 하는 부분
    int search;
    int sbutton;
    int layout;
    int userview ;
    int cartv ;
    int finishv;
    String table;
    ArrayList<String> catlist;
    Integer[] category;
    Button[] c_one;
    int[] on_off;

    //이하는 공통사용
    SharedPreferences sroot;
    SharedPreferences pref;
    ListView listView;
    UserListAdapter adapter;
    Button finish;
    ImageView cart;
    EditText searchtext;
    HashMap<String,ArrayList<PointModel>> postmap = new HashMap<>();//받아온 모든 카테고리 저장
    List inview;
    Button SB;


    int one_pick = 1;

    final RSinterface networkService = RetrofitHelper.create();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);

        for (String c : catlist){
            GetData(area,c);
        }

    }

    public void AfterData(int areacode){ //TODO 어떻게하면 드래그해서 더 불러올 수 있을것인가
        inview=postmap.get("all");
        adapter = new UserListAdapter(getApplicationContext(), inview);
        listView = (ListView) findViewById(userview);
        listView.setAdapter(adapter);
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        int position = pref.getInt("count", -1);
        Log.d("하트 누른거 뜨는거야 알겠지?", String.valueOf(position));
        searchtext = (EditText) findViewById(search);
        SB=findViewById(sbutton);

        for (int i=0; i<c_one.length; i++){ // 카테고리 형 변환
            c_one[i] = findViewById(category[i]);
        }
        for (int i=0; i<c_one.length; i++){
            final int INDEX;
            INDEX = i;
            Arrays.fill(on_off,0);
            on_off[0]=1;
            c_one[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int re = check_on_off(INDEX); // 체크 되었는지 표시
                    if (re == 0){ // 이미 체크된 것임
                        c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                        c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.black));
                        Log.d("test","테스트1");
                    }
                    else if (re == 1){ // 전에 체크 되지 않은 것
                        c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                        c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                        Log.d("test","테스트2");
                        adapter.ListUpdate(postmap.get(catlist.get(INDEX)));
                    }
                    else if (re == 2){ // 하나 이상 체크하려고 하는 경우
                        for (int i=0; i<on_off.length; i++){
                            if (on_off[i] == 1){
                                c_one[i].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn));
                                c_one[i].setTextColor(getApplication().getResources().getColor(R.color.black));
                                on_off[i] = 0;
                                Log.d("test","테스트3");
                            }
                        }
                        c_one[INDEX].setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.btn_));
                        c_one[INDEX].setTextColor(getApplication().getResources().getColor(R.color.main));
                        on_off[INDEX] = 1;
                        adapter.ListUpdate(postmap.get(catlist.get(INDEX)));
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
        searchtext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                InputMethodManager mInputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                switch (keyCode){
                    case KeyEvent.KEYCODE_ENTER:
                        SearchClass sc = new SearchClass(table,areacode,searchtext.getText().toString());
                        Call<PointList> call= networkService.searchPoint(sc);
                            call.enqueue(new Callback<PointList>() {
                                             @Override
                                             public void onResponse(Call<PointList> call, Response<PointList> response) {
                                                 try {
                                                     List point = response.body().pointlist;
                                                     ArrayList<PointModel> array = new ArrayList<>();
                                                     array.addAll(point);
                                                     adapter.ListUpdate(array);
                                                     searchtext.setText(null);
                                                     mInputMethodManager.hideSoftInputFromWindow(searchtext.getWindowToken(), 0);
                                                 }
                                                 catch (NullPointerException n){
                                                     //검색결과 없음
                                                     mInputMethodManager.hideSoftInputFromWindow(searchtext.getWindowToken(), 0);
                                                     searchtext.setText(null);
                                                 }

                                             }

                                             @Override
                                             public void onFailure(Call<PointList> call, Throwable t) {
                                                 //TODO 네트워크 오류 관련 추가

                                             }
                                         }
                            );
                        break;

                }
                return false;

            }
        });
        SB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager mInputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

                SearchClass sc = new SearchClass(table,areacode,searchtext.getText().toString());
                Call<PointList> call= networkService.searchPoint(sc);
                call.enqueue(new Callback<PointList>() {
                                 @Override
                                 public void onResponse(Call<PointList> call, Response<PointList> response) {
                                     try {
                                         List point = response.body().pointlist;
                                         ArrayList<PointModel> array = new ArrayList<>();
                                         array.addAll(point);
                                         adapter.ListUpdate(array);
                                         searchtext.setText(null);
                                         mInputMethodManager.hideSoftInputFromWindow(searchtext.getWindowToken(), 0);

                                     }
                                     catch (NullPointerException n){
                                         //검색결과 없음
                                         mInputMethodManager.hideSoftInputFromWindow(searchtext.getWindowToken(), 0);
                                         searchtext.setText(null);
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

    public void GetData(int area, String cat){
        WPClass post = new WPClass(table,area,cat); //todo 카테고리 검색은 여기다 catlist넣어서
        Call<PointList> call= networkService.getPoint(post);
            call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    setContentView(layout);
                    postmap.put(cat,array);
                    if (postmap.size()== catlist.size()){ //TODO 이거 띄울때까지 로딩 빙글빙글 가능한가?
                        AfterData(area);
                    }
                }
            }
            @Override
            public void onFailure(Call<PointList> call, Throwable t) {
                //TODO 인터넷 연결 관련 팝업창 띄우기

            }
        });
    }
    



}
