package com.kw.opal;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

public class SingerItemView1 extends LinearLayout {

    TextView textView;
    ImageView imageview;
    RouteModel rm;



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
    }




}