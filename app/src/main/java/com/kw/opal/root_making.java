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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.annotation.SuppressLint;
import android.widget.Spinner;

public class root_making extends AppCompatActivity {
    //새로 정의 해야 하는 부분
    int search;
    int sbutton=R.id.button_s;
    int layout=R.layout.new_root_making;
    int userview =R.id.userListTextView;
    int cartv =R.id.cart;
    int finishv =R.id.finish;
    ArrayList<String> catlist1 = new ArrayList<>(Arrays.asList("all","A0101","A0102","A0201","A0202","A0203","A0205","A0204"));
    ArrayList<String> catlist2 = new ArrayList<>(Arrays.asList("all","A05020100","A05020200","A05020400","A05020300","A05020900","A05020500","A05020600","A05020700","A05020800"));
    ArrayList<String> catlist3 = new ArrayList<>(Arrays.asList("all","A0303","A0302","A0305","A0304"));
    ArrayList<String> catlist4 = new ArrayList<>(Arrays.asList("all", "A04010200", "A04010100", "A04010900", "A04010700", "A04010800", "A04010600", "A04010300", "A04010400"));
    ArrayList<String> catlist5 = new ArrayList<>(Arrays.asList("all","A02060100","A02060300","A02060500","A02060600","A02060700","A02060900","A02060200","A02061100","A02060400"));
    ArrayList<String> catlist6 = new ArrayList<>(Arrays.asList("all","B02010700", "B020101600", "B02010900", "B02010100", "B02011100", "B02010500", "B02011000", "B02010600", "B02010400"));
    ArrayList<ArrayList> catlist =new ArrayList<>(Arrays.asList(catlist1,catlist2,catlist3,catlist4,catlist5,catlist6));
    Integer[] category;
    Button[] c_one;
    int[] on_off;
    int spinner_field_id;
    Button T_city,T_food,T_repo,T_shop,T_cult,T_hotel;



    //이하는 공통사용
    ArrayAdapter<String> sadapter1;
    ArrayList<String> tablelist=new ArrayList<>(Arrays.asList("city","food","reop","shop","cult","hotel"));
    Button more30Button;
    View footer;
    SharedPreferences sroot;
    SharedPreferences pref;
    ListView listView;
    UserListAdapter adapter;
    Button finish;
    ImageView cart;
    EditText searchtext;
    HashMap<String,ArrayList<PointModel>> postmap = new HashMap<>();//받아온 모든 카테고리 저장 ->카테고리 대신 테이블 저장
    List inview;
    Button SB;
    Spinner spinner_field1;
    Spinner spinner_field2;
    ArrayList <String> tablenumber=new ArrayList<>(Arrays.asList("12","39","28","38","14","32"));//12관광지 39음식 28레포츠 38쇼핑 14문화 32숙박
    int currentcat =0;
    int currenttable =0;
    int currentidx =0; //현재 카테고리 //테이블 바뀌면 초기화
    int currentsort =1; //현재 정렬 1-인기 2-이름 3-역이름 //테이블 바뀌면 초기화
    List<String> sort = Arrays.asList(new String[]{"F","T","NT"});
    int catarray = R.array.cat1Array;

    int one_pick = 1;
    ArrayList<String> arr1 =  new ArrayList<String>(Arrays.asList("전체", "자연","희귀경관","역사","휴양지","체험","건축물","산업"));
    ArrayList<String> arr2 =  new ArrayList<String>(Arrays.asList("전체", "한식","양식","중식","일식","카페","아시아식","패밀리레스토랑","이색 음식","채식"));
    ArrayList<String> arr3 =  new ArrayList<String>(Arrays.asList("전체", "육상레포츠","수상레포츠","복합레포츠","항공레포츠"));
    ArrayList<String> arr4 =  new ArrayList<String>(Arrays.asList("전체", "상설시상","5일장","특산물","공예공방","관광기념품","전문상가","백화점","면세점"));
    ArrayList<String> arr5 =  new ArrayList<String>(Arrays.asList("전체", "박물관","전시관","미술관","공연장","문화원","도서관","기념관","문화전수시설","컨벤션센터"));
    ArrayList<String> arr6 =  new ArrayList<String>(Arrays.asList("전체", "펜션","한옥","모텔","관광호텔","게스트하우스","콘도","민박","유스호스텔","가족호텔"));
    ArrayList<String> currentarr =  new ArrayList<String>(arr1);

    final RSinterface networkService = RetrofitHelper.create();
    DbOpenHelper helper ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        int area = sroot.getInt("area",0);
        for (String c : tablelist){
            GetData(area,c);
        }

    }

    public void AfterData(int areacode){
        inview=postmap.get("city");
        adapter = new UserListAdapter(getApplicationContext(), inview);
        adapter.setTypeID(tablenumber.get(currenttable));
        listView = (ListView) findViewById(userview);
        footer=getLayoutInflater().inflate(R.layout.more30,null,false);
        listView.addFooterView(footer);
        listView.setAdapter(adapter);
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        int position = pref.getInt("count", -1);
        searchtext = (EditText) findViewById(search);
        SB=findViewById(R.id.button_s);
//스피너 섹션
        spinner_field1 = (Spinner) findViewById(R.id.spinner_cat);

        sadapter1= new ArrayAdapter<String>(this, R.layout.spin_layout,currentarr);
        sadapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);//드롭다운 spindrop
        spinner_field1.setAdapter(sadapter1);
        spinner_field1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (currentcat!=position){
                    ArrayList<String> cc=catlist.get(currenttable);
                    GetData2(areacode,cc.get(position),sort.get(currentsort),adapter);
                    currentcat=position;
                    listView.smoothScrollToPosition(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_field2 = (Spinner) findViewById(R.id.spinner_order);

        ArrayAdapter<CharSequence> sadapter2= ArrayAdapter.createFromResource(this,R.array.spinnerArray, R.layout.spin_layout);
        sadapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);//드롭다운 spindrop
        spinner_field2.setAdapter(sadapter2);
        spinner_field2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentsort!=position){
                    ArrayList<String> cc=catlist.get(currenttable);
                    GetData2(areacode,cc.get(currentcat),sort.get(position),adapter);
                    currentsort=position;
                    listView.smoothScrollToPosition(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        more30Button = (Button) footer.findViewById(R.id.more30);
        more30Button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> cc=catlist.get(currenttable);
                GetData3(areacode,cc.get(currentcat),sort.get(currentsort),adapter );
            }
        });
        T_city = findViewById(R.id.button_p);
        T_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=0) {
                    currentarr.clear();
                    currentarr.addAll(arr1);
                    sadapter1.setNotifyOnChange(true);
                    sadapter1.notifyDataSetChanged();
                    currenttable=0;
                    currentsort = 0;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });
        T_food = findViewById(R.id.button_f);
        T_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=1) {
                    currentarr.clear();
                    currentarr.addAll(arr2);
                    sadapter1.setNotifyOnChange(true);
                    sadapter1.notifyDataSetChanged();
                    currenttable=1;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });
        T_repo = findViewById(R.id.button_r);
        T_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=2) {
                    currentarr.clear();
                    currentarr.addAll(arr3);
                    sadapter1.notifyDataSetChanged();
                    currenttable=2;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });
        T_shop = findViewById(R.id.button_sh);
        T_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=3) {
                    currentarr.clear();
                    currentarr.addAll(arr4);
                    sadapter1.notifyDataSetChanged();
                    currenttable=3;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });
        T_cult = findViewById(R.id.button_cu);
        T_cult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=4) {
                    currentarr.clear();
                    currentarr.addAll(arr5);
                    sadapter1.notifyDataSetChanged();
                    currenttable=4;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });
        T_hotel = findViewById(R.id.button_ho);
        T_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currenttable!=5) {
                    currentarr.clear();
                    currentarr.addAll(arr6);
                    sadapter1.setNotifyOnChange(true);
                    sadapter1.notifyDataSetChanged();
                    currenttable=5;
                    currentcat=0;
                    GetData2(areacode,"all",sort.get(currentsort),adapter);
                    listView.smoothScrollToPosition(0);
                    spinner_field1.setSelection(0);
                    spinner_field2.setSelection(0);
                }
            }
        });

        finish = findViewById(finishv);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent finish_root = new Intent(getApplicationContext(),final_route_2.class);
                finish_root.putExtra("check", 1);
                startActivity(finish_root);
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
        /*
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

                SearchClass sc = new SearchClass("all",areacode,searchtext.getText().toString());
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

*/

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

    public void GetData(int area, String table){//최초검색
        WPClass post = new WPClass(table,area,"all","F");
        Log.d("test",post.toString());
        Call<PointList> call= networkService.getPoint(post);
            call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    setContentView(layout);
                    postmap.put(table,array);
                    if (postmap.size()== tablelist.size()){ //TODO 이거 띄울때까지 로딩 빙글빙글 가능한가?
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

    public void GetData2(int area, String cat,String order, UserListAdapter adapter){
        WPClass post = new WPClass(tablelist.get(currenttable),area,cat,order); //todo 카테고리 검색은 여기다 catlist넣어서
        Call<PointList> call= networkService.getPoint(post);
        call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);
                    adapter.ListUpdate(array);
                    listView.smoothScrollToPosition(0);
                }
            }
            @Override
            public void onFailure(Call<PointList> call, Throwable t) {
                //TODO 인터넷 연결 관련 팝업창 띄우기

            }
        });
    }
    public void GetData3(int area,String cat,String order, UserListAdapter adapter){ //카테고리 변경
        List<PointModel> orgin = adapter.getList();
        int idx=orgin.size();
        More30Class post = new More30Class(tablelist.get(currenttable),area,cat,order,idx); //todo 카테고리 검색은 여기다 catlist넣어서
        Call<PointList> call= networkService.plusPoint(post);
        call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    if(response.code()!=204){
                        List point = response.body().pointlist;
                        ArrayList<PointModel> array = new ArrayList<>();
                        array.addAll(orgin);
                        array.addAll(point);
                        adapter.ListUpdate(array);
                    }
                    else{
                        //TODO 204 더 불러올 코드 없음
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
