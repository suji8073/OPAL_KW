package com.kw.opal;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;


public class final_route_1 extends AppCompatActivity {

    Button next;
    ImageView circle1, circle2, circle3;
    reDBOpenHelper helper;
    Cursor mCur;
    Cursor mCur1;
    MapView mapView1;
    ViewGroup mapViewContainer;

    int sfs=0;
    ArrayList<String> Name = new ArrayList<String>();

    double[][] Location ;
    int  j;
    double a;
    double one;
    double two;
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.final_route_1);
        helper = new reDBOpenHelper(final_route_1.this);
        mCur1 = helper.sortColumn();
        if (mCur1 != null && mCur1.moveToLast()) {
            System.out.println(mCur1.getString(4));
            code = mCur1.getInt(7);
            System.out.println("코드는" + code);
        }


        mCur = helper.selectC(String.valueOf(code));
        if (mCur != null && mCur.moveToFirst()) {

            System.out.println(mCur.getString(2));
            sfs = mCur.getCount();
            Location = new double[sfs][2];

            for(int j=0;j<mCur.getCount();j++) {
                Name.add(mCur.getString(2));
                one = mCur.getDouble(5);
                two = mCur.getDouble(6);
                Log.d("test", String.valueOf(one));
                Log.d("test", String.valueOf(two));
                Location[j][0] = two;
                Location[j][1] = one;
                mCur.moveToNext();

            }
        }
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
        circle1.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        next = findViewById(R.id.next);



        mapView1 = new MapView(this);


        mapViewContainer = (ViewGroup) findViewById(R.id.map_view);


        MapPOIItem marker = new MapPOIItem();

        mapView1.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(Location[0][0], Location[0][1]), true);
        mapView1.setZoomLevel(1, true);
        marker.setTag(0);


        MapPoint[] MARKER_POINT = new MapPoint[sfs];//TODO 장바구니 개수에 따라 유동적으로 생성

        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(100, 255, 51, 0)); // Polyline 컬러 지정.


        for (int i = 0; i < Location.length; i++) {
            double lat = Location[i][0];
            double lon = Location[i][1];
            Log.d("test", String.valueOf(lat)+" 그리고 "+String.valueOf(lon));
            MARKER_POINT[i] = MapPoint.mapPointWithGeoCoord(lat, lon);
            polyline.addPoint(MapPoint.mapPointWithGeoCoord(lat, lon));
            marker.setItemName(Name.get(i));
            marker.setMapPoint(MARKER_POINT[i]);
            marker.setMarkerType(MapPOIItem.MarkerType.YellowPin); // 기본으로 제공하는 BluePin 마커 모양.
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
            mapView1.addPOIItem(marker);
        }


        // Polyline 지도에 올리기.
        mapView1.addPolyline(polyline);

        // 지도뷰의 중심좌표와 줌레벨을 Polyline이 모두 나오도록 조정.
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100;
        mapView1.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));
        mapViewContainer.addView(mapView1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(final_route_1.this, MainActivityAll.class);
                start_intent.putExtra("check", 1);
                finishAffinity();
                startActivity(start_intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView1.removeAllPOIItems();
        mapView1.removeAllPolylines();
        mapViewContainer.invalidate();
        mapView1.invalidate();
    }
}