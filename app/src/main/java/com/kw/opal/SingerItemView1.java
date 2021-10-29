package com.kw.opal;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class SingerItemView1 extends LinearLayout {

    TextView textView;
    ImageView imageview;
    RouteModel rm;
    LinearLayout RouteB;


    // Generate > Constructor

    public SingerItemView1(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.smart_list, this, true);

        textView = (TextView) findViewById(R.id.smart_title);
        imageview =(ImageView) findViewById(R.id.smart_image);
        RouteB = (LinearLayout)findViewById(R.id.routeB);


    }
    public void setmodel(RouteModel model){
        rm=model;
        textView.setText(rm.getName());
        if (rm.getImage() != null){
            Glide.with(this).load(rm.getImage()).into(imageview);
        }
        else{
            imageview.setImageResource(R.drawable.no_camera);
        }
        RouteB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_intent = new Intent(getContext(), routeinfo.class);
                start_intent.putExtra("Id",rm.getId());
                start_intent.putExtra("Name",rm.getName());
                getContext().startActivity(start_intent.addFlags(FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }




}