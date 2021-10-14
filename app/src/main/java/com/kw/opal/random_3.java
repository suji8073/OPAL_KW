package com.kw.opal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class random_3 extends AppCompatActivity {

    Button random_choice_next;
    static final String[] LIST_MENU = {"LIST1", "LIST2", "LIST3","LIST4", "LIST5"} ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_3);


        /*MapView mapView = new MapView(this);
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

        mapViewContainer.addView(mapView);*/
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

