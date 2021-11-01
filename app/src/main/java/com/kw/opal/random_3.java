package com.kw.opal;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import net.daum.mf.map.api.CameraUpdate;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapCircle;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class random_3 extends AppCompatActivity {

    Integer[] layout_num = {R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5};
    LinearLayout[] layout = new LinearLayout[5];

    Integer[] name = {R.id.Name1, R.id.Name2, R.id.Name3, R.id.Name4, R.id.Name5};
    TextView[] Name = new TextView[5];

    Integer[] address = {R.id.juso1, R.id.juso2, R.id.juso3, R.id.juso4, R.id.juso5};
    TextView[] juso = new TextView[5];

    Integer[] picture = {R.id.poster1, R.id.poster2, R.id.poster3, R.id.poster4, R.id.poster5};
    ImageView[] poster = new ImageView[5];

    Integer[] infoid ={R.id.info1,R.id.info2,R.id.info3,R.id.info4,R.id.info5};
    Integer[] choid ={R.id.cho1,R.id.cho2,R.id.cho3,R.id.cho4,R.id.cho5};
    Button[] info = new Button[5];
    Button[] cho = new Button[5];

    Integer id1;
    String one, two, three, four;
    DbOpenHelper helper ;
    int count=0;
    String TypeID;

    MapView mapView;
    ViewGroup mapViewContainer;

    ArrayList <Double> xlist=new ArrayList<>();
    ArrayList <Double> ylist=new ArrayList<>();
    ArrayList <MapPolyline> polinelist=new ArrayList<>();
    ArrayList <String> namelist=new ArrayList<>();
    SharedPreferences sroot;

    Set<String> set = new HashSet<String>();
    double[][] location ; // 위치 좌표
    String[] NameT ;

    String MAINNAME ; // 대표 관광지 이름
    double[] MAINLOCATION =new double[2]; // 대표 관광지 위치
    String mainid;
    String maintypeid;
    String mainimage;
    final RSinterface networkService = RetrofitHelper.create();
    Button next;
    Button back;

    MapPOIItem[] listmarker=new MapPOIItem[5];
    MapPoint[] listpoint=new MapPoint[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MAINNAME=getIntent().getStringExtra("name");
        sroot = getSharedPreferences("root", Activity.MODE_PRIVATE);
        String tx=getIntent().getStringExtra("x");
        String ty=getIntent().getStringExtra("y");
        Double dx=Double.parseDouble(tx);
        Double dy=Double.parseDouble(ty);
        xlist.add(dx);
        ylist.add(dy);
        namelist.add(getIntent().getStringExtra("name"));
        MAINLOCATION[0]= xlist.get(0);
        MAINLOCATION[1]= ylist.get(0);

        setContentView(R.layout.random_3);

        for (int i=0; i<layout_num.length; i++){
            layout[i] = findViewById(layout_num[i]);
        }

        for (int i=0; i<name.length; i++){  // 관광지 이름
            Name[i] = findViewById(name[i]);
        }

        for (int i=0; i<address.length; i++){  // 관광지 주소
            juso[i] = findViewById(address[i]);
        }
        for (int i=0; i<picture.length; i++){ // 관광지 사진
            poster[i] = findViewById(picture[i]);
        }
        for (int i=0; i<cho.length; i++){ // 관광지 사진
            cho[i] = findViewById(choid[i]);
        }
        for (int i=0; i<info.length; i++){ // 관광지 사진
            info[i] = findViewById(infoid[i]);
        }



        mapView = new MapView(this);
        mapViewContainer = (ViewGroup) findViewById(R.id.map_view);





        Settinglist();



    }






    private void drawRoutePolyline(double x, double y) //추가된 폴리라인이 있으면 날리기. 저장된 어레이리스트 갯수랑 폴리라인 갯수 같으면(간선이니깐)
    {
        mapView.removeAllPolylines();
        for (int j=0;j< polinelist.size();j++)
        {
            mapView.addPolyline(polinelist.get(j));
        }
        MapPolyline polyline = new MapPolyline(); /* MapPolyline 객체 생성 */
        polyline.setTag(8278); /* polyline Tag 번호 지정 */
        polyline.setLineColor(Color.argb(128, 255, 51, 0)); /* polyline 색 지정 */

        polyline.addPoint(MapPoint.mapPointWithGeoCoord(MAINLOCATION[1], MAINLOCATION[0])); // 대표관광지
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(y, x));

        mapView.addPolyline(polyline); /* polyline 지도에 그리기 */


    }

    private void Settinglist(){
        if (mapView.getParent() !=null) {
            ((ViewGroup) mapView.getParent()).removeView(mapView);
            mapView = new MapView(this);
        }
        for (int i=0;i<xlist.size();i++){// 전부 띄우기
            MapPOIItem marker = new MapPOIItem();
            marker.setItemName(namelist.get(i)); // 대표 관광지 이름
            marker.setTag(0);
            MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(ylist.get(i), xlist.get(i)); // 대표관광지 좌표
            marker.setMapPoint(MARKER_POINT);
            marker.setMarkerType(MapPOIItem.MarkerType.YellowPin); //
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
            mapView.addPOIItem(marker);
        }
        for (int j=0;j<polinelist.size();j++){
            mapView.addPolyline(polinelist.get(j));
        }
        MAINLOCATION[0]=xlist.get(xlist.size()-1);
        MAINLOCATION[1]=ylist.get(ylist.size()-1);
        MAINNAME=namelist.get(namelist.size()-1);
        int area = sroot.getInt("area",0);
        CheckClass post = new CheckClass("all",area,MAINLOCATION[0],MAINLOCATION[1]);
        Call<PointList> call= networkService.checkPoint(post);
        call.enqueue(new Callback<PointList>() {
            @Override
            public void onResponse(Call<PointList> call, Response<PointList> response) {
                if(response.isSuccessful()){
                    List point = response.body().pointlist;
                    ArrayList<PointModel> array = new ArrayList<>();
                    array.addAll(point);


                    //이하 페이지 세팅

                    MapPOIItem marker = new MapPOIItem();

                    mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(MAINLOCATION[1], MAINLOCATION[0]), true); // 중심점 변경
                    mapView.setZoomLevel(7, true); // 줌레벨 변경
                    // 줌 인
                    mapView.zoomIn(true);
                    // 줌 아웃
                    mapView.zoomOut(true);
                    marker.setTag(0);


                    marker.setItemName(MAINNAME); // 대표 관광지 이름
                    marker.setTag(0);
                    MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(MAINLOCATION[1], MAINLOCATION[0]); // 대표관광지 좌표
                    marker.setMapPoint(MARKER_POINT);
                    marker.setMarkerType(MapPOIItem.MarkerType.YellowPin); // 기본으로 제공하는 BluePin 마커 모양.
                    marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

                    mapView.addPOIItem(marker);

                    MapCircle circle1 = new MapCircle(
                            MapPoint.mapPointWithGeoCoord(MAINLOCATION[1], MAINLOCATION[0]), // center
                            10000, // radius
                            Color.argb(128, 255, 0, 0), // strokeColor
                            Color.argb(128, 0, 255, 0) // fillColor
                    );
                    circle1.setTag(1234);
                    mapView.addCircle(circle1);
                    next=findViewById(R.id.next);
                    back=findViewById(R.id.back);
                    back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(count>0){
                                count-=count;
                                mapView.removeAllPOIItems();
                                xlist.remove(xlist.size()-1);
                                ylist.remove(ylist.size()-1);
                                helper.deleteColumn(namelist.get(namelist.size()-1));
                                namelist.remove(namelist.size()-1);
                                mapView.removePolyline(polinelist.get(polinelist.size()-1));
                                polinelist.remove(polinelist.size()-1);
                                //장바구니 마지막 삭제
                                Settinglist();
                            }

                        }
                    });

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mapView.getParent() !=null) {
                                ((ViewGroup) mapView.getParent()).removeView(mapView);
                            }
                            Intent finish_root = new Intent(getApplicationContext(),final_route_2.class);
                            finish_root.putExtra("check", 1);
                            startActivity(finish_root);

                        }
                    });

                    for (int i=0; i<array.size(); i++) {
                        final int INDEX;
                        INDEX = i;
                        listpoint[INDEX]=MapPoint.mapPointWithGeoCoord(array.get(INDEX).getMap_y(), array.get(INDEX).getMap_x());
                        MapPOIItem item = new MapPOIItem();
                        listmarker[INDEX]=item;
                        listmarker[INDEX].setItemName(array.get(INDEX).getName()); // 클릭한 관광지 이름
                        listmarker[INDEX].setMapPoint(listpoint[INDEX]);

                        mapView.addPOIItem(listmarker[INDEX]);
                        Name[INDEX].setText(array.get(INDEX).getName());
                        juso[INDEX].setText(array.get(INDEX).getAddr());
                        if (array.get(INDEX).getImage() == null){
                            poster[INDEX].setImageResource(R.drawable.no_camera);
                        }
                        else{
                            Glide.with(getApplicationContext()).load(array.get(INDEX).getImage()).into(poster[INDEX]);

                        }


                        layout[INDEX].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                MapPOIItem marker1 = new MapPOIItem();
                                marker1.setItemName(MAINNAME); // 대표 관광지 이름

                                marker1.setTag(0);

                                drawRoutePolyline(array.get(INDEX).getMap_x(),array.get(INDEX).getMap_y());


                            }
                        });

                        info[INDEX].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent start_intent = new Intent(getApplicationContext(), tourism.class);
                                start_intent.putExtra("Id",array.get(INDEX).getId());
                                start_intent.putExtra("TypeId",array.get(INDEX).getContentTypeId());
                                startActivity(start_intent.addFlags(FLAG_ACTIVITY_NEW_TASK));

                            }
                        });

                        cho[INDEX].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String area_name;
                                area_name = sroot.getString("area_name", "");
                                helper = new DbOpenHelper(getApplicationContext());

                                id1=Integer.valueOf(array.get(INDEX).getId());
                                one = String.valueOf(array.get(INDEX).getName());
                                two = String.valueOf(array.get(INDEX).getAddr());
                                three = String.valueOf(array.get(INDEX).getImage());
                                Float x = Float.valueOf(array.get(INDEX).getMap_x());
                                Float y = Float.valueOf(array.get(INDEX).getMap_y());
                                String typeid=String.valueOf(array.get(INDEX).getContentTypeId());
                                set.addAll(Collections.singleton(one));
                                set.addAll(Collections.singleton(two));
                                set.addAll(Collections.singleton(three));
                                //set.addAll(Collections.singleton(String.valueOf(position)));

                                helper.open();

                                helper.insertColumn(id1, one, three,two,x,y,area_name,typeid);

                                xlist.add(Double.valueOf(array.get(INDEX).getMap_x()));
                                ylist.add(Double.valueOf(array.get(INDEX).getMap_y()));
                                namelist.add(array.get(INDEX).getName());

                                MapPolyline polyline = new MapPolyline(); /* MapPolyline 객체 생성 */
                                polyline.setTag(8278); /* polyline Tag 번호 지정 */
                                polyline.setLineColor(Color.argb(128, 255, 51, 0)); /* polyline 색 지정 */

                                polyline.addPoint(MapPoint.mapPointWithGeoCoord(MAINLOCATION[1], MAINLOCATION[0])); // 대표관광지
                                polyline.addPoint(MapPoint.mapPointWithGeoCoord(Double.valueOf(array.get(INDEX).getMap_y()), Double.valueOf(array.get(INDEX).getMap_x())));
                                polinelist.add(polyline);
                                mapView.addPolyline(polyline); /* polyline 지도에 그리기 */

                                count+=count;
                                mapView.removeAllPOIItems();
                                Settinglist();


                            }
                        });

                    }
                    if (array.size()!=5){
                        for (int k=0;k<5-array.size();k++){
                            final int INDEX;
                            INDEX = 5-k-1;
                            Name[INDEX].setText("정보가 없습니다");
                            juso[INDEX].setText("정보가 없습니다");
                            poster[INDEX].setImageResource(R.drawable.no_camera);

                        }
                    }

                    mapViewContainer.addView(mapView);


                    }
                }
            @Override
            public void onFailure(Call<PointList> call, Throwable t) {
                //TODO 인터넷 연결 관련 팝업창 띄우기

            }
        });

    }

}

