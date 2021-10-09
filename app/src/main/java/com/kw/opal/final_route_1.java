package com.kw.opal;

import android.content.Intent;
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


public class final_route_1 extends AppCompatActivity {

    Button next;
    ImageView circle1, circle2, circle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_route_1);

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

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        MapPOIItem marker = new MapPOIItem();

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mapView.setZoomLevel(1, true);
        marker.setTag(0);

        double[][] location = { { 37.537229, 127.005515 }, { 37.545024,127.03923 }, { 37.527896,127.036245 },  {37.541889,127.095388}}; // 위치 좌표
        String[] Name = {"마라탕", "짜장면", "탕수육", "짬뽕"}; //관광지 이름 순서대로
        MapPoint[] MARKER_POINT = new MapPoint[4];


        for (int i=0; i<location.length; i++){
            MARKER_POINT[i] = MapPoint.mapPointWithGeoCoord(location[i][0], location[i][1]);
            marker.setItemName(Name[i]);
            marker.setMapPoint(MARKER_POINT[i]);
            marker.setMarkerType(MapPOIItem.MarkerType.YellowPin); // 기본으로 제공하는 BluePin 마커 모양.
            marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
            mapView.addPOIItem(marker);
        }


        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(100, 255, 51, 0)); // Polyline 컬러 지정.

        // Polyline 좌표 지정.
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.537229, 127.005515));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.545024,127.03923));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.527896,127.036245));
        polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.541889,127.095388));

        // Polyline 지도에 올리기.
        mapView.addPolyline(polyline);

        // 지도뷰의 중심좌표와 줌레벨을 Polyline이 모두 나오도록 조정.
        MapPointBounds mapPointBounds = new MapPointBounds(polyline.getMapPoints());
        int padding = 100;
        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(mapPointBounds, padding));

        mapViewContainer.addView(mapView);

    }

}

