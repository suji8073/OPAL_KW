package com.kw.opal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapCircle;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;


public class random_3 extends AppCompatActivity {

    Integer[] layout_num = {R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5};
    LinearLayout[] layout = new LinearLayout[5];

    Integer[] name = {R.id.Name1, R.id.Name2, R.id.Name3, R.id.Name4, R.id.Name5};
    TextView[] Name = new TextView[5];

    Integer[] address = {R.id.juso1, R.id.juso2, R.id.juso3, R.id.juso4, R.id.juso5};
    TextView[] juso = new TextView[5];

    Integer[] picture = {R.id.poster1, R.id.poster2, R.id.poster3, R.id.poster4, R.id.poster5};
    ImageView[] poster = new ImageView[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        MapPOIItem marker = new MapPOIItem();

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true); // 중심점 변경
        mapView.setZoomLevel(6, true); // 줌레벨 변경
        // 줌 인
        mapView.zoomIn(true);
        // 줌 아웃
        mapView.zoomOut(true);
        marker.setTag(0);

        marker.setItemName("Default Marker");
        marker.setTag(0);
        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        mapView.addPOIItem(marker);

        MapCircle circle1 = new MapCircle(
                MapPoint.mapPointWithGeoCoord(37.537094, 127.005470), // center
                1500, // radius
                Color.argb(128, 255, 0, 0), // strokeColor
                Color.argb(128, 0, 255, 0) // fillColor
        );
        circle1.setTag(1234);
        mapView.addCircle(circle1);

        MapPolyline polyline = new MapPolyline();
        polyline.setTag(1000);
        polyline.setLineColor(Color.argb(128, 255, 51, 0)); // Polyline 컬러 지정.

        double[][] location = { { 37.537229, 127.005515 }, { 37.537229, 127.005515 }, { 37.545024,127.03923 }, { 37.527896,127.036245 },  {37.541889,127.095388}}; // 위치 좌표

        for (int i=0; i<layout_num.length; i++) {
            final int INDEX;
            INDEX = i;

            layout[INDEX].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    MapPOIItem marker1 = new MapPOIItem();
                    marker1.setItemName("Default Marker");
                    marker1.setTag(0);

                    polyline.addPoint(MapPoint.mapPointWithGeoCoord(37.537229, 127.005515)); // 대표관광지
                    polyline.addPoint(MapPoint.mapPointWithGeoCoord(location[INDEX][0], location[INDEX][1]));

                    MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(location[INDEX][0], location[INDEX][1]);
                    marker1.setMapPoint(MARKER_POINT);

                    mapView.addPOIItem(marker1);
                    mapView.addPolyline(polyline);

                }
            });
        }


        mapViewContainer.addView(mapView);




    }

    public void OnClickThreechoice(View view) {
        final CharSequence[] oItems = {"관광지", "음식점 및 카페", "숙박"};

        AlertDialog.Builder oDialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog_Alert);

        String strHtml =
                "다음으로 이동할 장소를 <b><font color='#3A4CA8'>선택</font></b> 해주세요!";
        Spanned oHtml;

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
            // noinspection deprecation
            oHtml = Html.fromHtml(strHtml);
        }
        else
        {
            oHtml = Html.fromHtml(strHtml, Html.FROM_HTML_MODE_LEGACY);
        }


        oDialog.setTitle(oHtml)
                .setItems(oItems, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(),
                                oItems[which], Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("경로 선택 완료하기", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Intent start_intent = new Intent(getApplicationContext(), com.kw.opal.final_route_2.class);
                        startActivity(start_intent);
                    }
                })
                .show();


    }


}

