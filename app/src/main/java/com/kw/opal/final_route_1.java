package com.kw.opal;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
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
        setContentView(R.layout.final_route_1);
        helper = new reDBOpenHelper(final_route_1.this);

        mCur1=helper.sortColumn();
        if (mCur1 != null&& mCur1.moveToFirst() ) {
            System.out.println(mCur1.getString(4));
            code=mCur1.getInt(7);
            System.out.println("코드는"+code);}


        mCur=helper.selectC(code);
        if (mCur != null&& mCur.moveToFirst() ) {

            System.out.println(mCur.getString(2));
            int sfs = mCur.getCount();
            Location = new double[sfs][2];
            int j = 0;
            while (mCur.moveToNext()) {
                Name.add(mCur.getString(2));
                one = mCur.getDouble(5);
                two = mCur.getDouble(6);
                Location[j][0] = one;
                Location[j][1] = two;
                j++;

            }
        }
        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
        circle1.setColorFilter(getApplication().getResources().getColor(R.color.main2));
        circle2.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        circle3.setColorFilter(getApplication().getResources().getColor(R.color.gray));
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(final_route_1.this, final_route_2.class);
                start_intent.putExtra("check", 1);
                startActivity(start_intent);
            }
        });
        MapView mapView1 = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        MapPOIItem marker = new MapPOIItem();

        mapView1.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(Location[0][0], Location[0][1]), true);
        mapView1.setZoomLevel(1, true);
        marker.setTag(0);

       MapPoint[] MARKER_POINT = new MapPoint[4];



        for (int i=0; i<Location.length; i++){
            MARKER_POINT[i] = MapPoint.mapPointWithGeoCoord(Location[i][0], Location[i][1]);
            marker.setItemName(Name.get(i));
            marker.setMapPoint(MARKER_POINT[i]);
            marker.setMarkerType(MapPOIItem.MarkerType.YellowPin); // 기본으로 제공하는 BluePin 마커 모양.
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
            mapView1.addPOIItem(marker);
        }
        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(100, 255, 51, 0)); // Polyline 컬러 지정.

        // Polyline 좌표 지정.

        for (int m=0;m<Location.length;m++){
            polyline.addPoint(MapPoint.mapPointWithGeoCoord(Location[m][0], Location[m][1]));
        }
        // Polyline 지도에 올리기.
        mapView1.addPolyline(polyline);

        // 지도뷰의 중심좌표와 줌레벨을 Polyline이 모두 나오도록 조정.
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100;
        mapView1.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));
        mapViewContainer.addView(mapView1);
        }
    }