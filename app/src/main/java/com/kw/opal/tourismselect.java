package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class tourismselect extends AppCompatActivity {
    String name;
    String addr;
    String conv;
    String inform="";
    String site;
    String MainimgURL;
    String phone;
    SharedPreferences sroot;
    Integer id1;
    String one, two, three, area_name,x,y;
    String contentId;
    String contentTypeId;

    ImageView back_main,mainimage;
    TextView theme_name, address, url;
    TextView text1_theme,text2_theme;
    String tourism_url;
    Button random_intent_yes, random_intent_no;
    final Tourinterface networkService = RetrofitHelper2.create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentId = getIntent().getStringExtra("Id");
        contentTypeId = getIntent().getStringExtra("TypeId");
        x =getIntent().getStringExtra("x");
        y =getIntent().getStringExtra("y");
        Log.d("test",contentId+" "+contentTypeId);
        informClass inform1 = new informClass(contentId,contentTypeId);
        inform2Class inform2 = new inform2Class(contentId,contentTypeId);
        inform3Class inform3 = new inform3Class(contentId,contentTypeId);
        HashMap<String,String> data1 = inform1.Makehashmap();
        HashMap<String,String> data2 = inform2.Makehashmap();
        HashMap<String,String> data3 = inform3.Makehashmap();
        Call<Commonintro> call = networkService.common(data1);
        call.enqueue(new Callback<Commonintro>() {
            @Override
            public void onResponse(Call<Commonintro> call, Response<Commonintro> response) {
                Log.d("test","0");
                Commonintro C = response.body();
                name=C.response.body.items.item.getTitle();
                MainimgURL=C.response.body.items.item.getFirstimage();
                addr=C.response.body.items.item.getaddr1();
                conv=C.response.body.items.item.getOverview();
                site=C.response.body.items.item.getHomepage();
                phone=C.response.body.items.item.getTel();
                if (contentTypeId.equals("12")){
                    Call<Pointintro> call2 = networkService.pointintro(data2);
                    call2.enqueue(new Callback<Pointintro>() {
                        @Override
                        public void onResponse(Call<Pointintro> call, Response<Pointintro> response) {
                            Log.d("test","1");
                            Pointintro I =response.body();
                            inform=inform+I.response.body.items.item.getTextInfo();
                            Call<Detailrepeat> call3 = networkService.DetailPoint(data3);
                            call3.enqueue(new Callback<Detailrepeat>() {
                                @Override
                                public void onResponse(Call<Detailrepeat> call, Response<Detailrepeat> response) {
                                    Log.d("test","2");
                                    Detailrepeat D = response.body();
                                    inform=inform+D.response.body.items.getTextInfo();
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                                @Override
                                public void onFailure(Call<Detailrepeat> call, Throwable t) {
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                            });
                        }
                        @Override
                        public void onFailure(Call<Pointintro> call, Throwable t) {

                        }
                    });

                }
                else if (contentTypeId.equals("32")){
                    Call<Roomintro> call2 = networkService.hotelintro(data2);
                    call2.enqueue(new Callback<Roomintro>() {
                        @Override
                        public void onResponse(Call<Roomintro> call, Response<Roomintro> response) {
                            Log.d("test","1");
                            Roomintro I =response.body();
                            inform=inform+I.response.body.items.item.getTextInfo();
                            Call<Detailrepeat> call3 = networkService.DetailPoint(data3);
                            call3.enqueue(new Callback<Detailrepeat>() {
                                @Override
                                public void onResponse(Call<Detailrepeat> call, Response<Detailrepeat> response) {
                                    Log.d("test","2");
                                    Detailrepeat D = response.body();
                                    inform=inform+D.response.body.items.getTextInfo();
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                                @Override
                                public void onFailure(Call<Detailrepeat> call, Throwable t) {
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                            });
                        }
                        @Override
                        public void onFailure(Call<Roomintro> call, Throwable t) {

                        }
                    });

                }
                else if (contentTypeId.equals("38")){
                    Call<ShopIntro> call2 = networkService.shopintro(data2);
                    call2.enqueue(new Callback<ShopIntro>() {
                        @Override
                        public void onResponse(Call<ShopIntro> call, Response<ShopIntro> response) {
                            Log.d("test","1");
                            ShopIntro I =response.body();
                            inform=inform+I.response.body.items.item.getTextInfo();
                            Call<Detailrepeat> call3 = networkService.DetailPoint(data3);
                            call3.enqueue(new Callback<Detailrepeat>() {
                                @Override
                                public void onResponse(Call<Detailrepeat> call, Response<Detailrepeat> response) {
                                    Log.d("test","2");
                                    Detailrepeat D = response.body();
                                    inform=inform+D.response.body.items.getTextInfo();
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                                @Override
                                public void onFailure(Call<Detailrepeat> call, Throwable t) {
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                            });
                        }
                        @Override
                        public void onFailure(Call<ShopIntro> call, Throwable t) {

                        }
                    });

                }
                else if (contentTypeId.equals("39")){
                    Call<Foodintro> call2 = networkService.foodintro(data2);
                    call2.enqueue(new Callback<Foodintro>() {
                        @Override
                        public void onResponse(Call<Foodintro> call, Response<Foodintro> response) {
                            Log.d("test","1");
                            Foodintro I =response.body();
                            inform=inform+I.response.body.items.item.getTextInfo();
                            Call<Detailrepeat> call3 = networkService.DetailPoint(data3);
                            call3.enqueue(new Callback<Detailrepeat>() {
                                @Override
                                public void onResponse(Call<Detailrepeat> call, Response<Detailrepeat> response) {
                                    Log.d("test","2");
                                    Detailrepeat D = response.body();
                                    inform=inform+D.response.body.items.getTextInfo();
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                                @Override
                                public void onFailure(Call<Detailrepeat> call, Throwable t) {
                                    setContentView(R.layout.random_2);
                                    AfterData();
                                }
                            });
                        }
                        @Override
                        public void onFailure(Call<Foodintro> call, Throwable t) {
                        }
                    });
                }

            }
            @Override
            public void onFailure(Call<Commonintro> call, Throwable t) {

            }
        });
        // TODO 나머지 3개는 받는 모델 걍 하나로 합쳐버리자 그냥. 없으면 null처리하면 되겠지




    }
    public void AfterData(){
        Log.d("test",addr);


        mainimage = findViewById(R.id.mainimage);
        theme_name = findViewById(R.id.theme_name); //관광지 이름
        address = findViewById(R.id.address); // 관광지 주소
        text1_theme = findViewById(R.id.text1_theme); // 관광지 소개
        text2_theme = findViewById(R.id.text2_theme); //관광지 이용안내
        url = findViewById(R.id.url); // 관광지 홈페이지 url 넣을 장소
        url.setPaintFlags(url.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG); // 밑줄
        if (!isBlank(MainimgURL))
            Glide.with(this).load(MainimgURL).into(mainimage);
        theme_name.setText(name);
        address.setText(addr);
        text1_theme.setText(conv);
        text2_theme.setText(inform);


        if (!isBlank(site)){
            tourism_url = site; // 관광지 홈페이지 넣으면 됨
            Log.e("url", String.valueOf(url));

            //url 클릭하면 해당 홈페이지로 이동
            url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String[] array_url = tourism_url.split(" ");
                    Log.d("관광지 url 들어가는 지 확인", array_url[1]);
                    Log.d("관광지 url 들어가는 지 확인", array_url[1].substring(5, '\"'));
                    String real_url = array_url[1].substring(5);
                    String real_url1 = real_url.substring(1, real_url.length()-1);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(real_url1));
                    startActivity(intent);

                }
            });
        }
        else url.setText("");

        back_main = findViewById(R.id.back_main);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        random_intent_yes = findViewById(R.id.random_intent_yes); //TODO 장바구니에 넣고 좌표 인텐트 전달
        random_intent_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbOpenHelper helper1=new DbOpenHelper(getApplicationContext());
                sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
                area_name = sroot.getString("area_name", "");
                id1=Integer.valueOf(contentId);
                one = String.valueOf(name);
                two = String.valueOf(addr);
                if (!isBlank(MainimgURL))
                    three = String.valueOf(MainimgURL);
                else
                    three="";
                Float x1 = Float.valueOf(x);
                Float y1 = Float.valueOf(y);
                String typeid=String.valueOf(contentTypeId);
                helper1.open();
                helper1.insertColumn(id1, one, three,two,x1,y1,area_name,typeid);//area name 추가

                Intent start_intent = new Intent(getApplicationContext(), random_3.class);
                start_intent.putExtra("Id",id1);
                start_intent.putExtra("TypeId",typeid);
                start_intent.putExtra("x",String.valueOf(x1));
                start_intent.putExtra("y",String.valueOf(y1));
                start_intent.putExtra("image",three);
                start_intent.putExtra("name",name);
                start_intent.putExtra("addr",addr);
                startActivity(start_intent);


            }
        });
        random_intent_no = findViewById(R.id.random_intent_no); // 취소하기 버튼
        random_intent_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}