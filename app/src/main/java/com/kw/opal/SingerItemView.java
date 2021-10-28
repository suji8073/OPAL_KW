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

public class SingerItemView extends LinearLayout {

    TextView textView;
    ImageView imageView;
    PointModel pm;

    // Generate > Constructor

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.random_item, this, true);

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_intent = new Intent(context, tourismselect.class);
                start_intent.putExtra("Id",pm.getId());
                start_intent.putExtra("TypeId",pm.getContentTypeId());
                context.startActivity(start_intent.addFlags(FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }
    public void setPoint(PointModel point) {
        pm=point;
        textView.setText(pm.getName());
        if (pm.getImage() != null){
            Log.d("test",pm.getImage());
            Glide.with(this).load(pm.getImage()).into(imageView);
        }
        else{
            imageView.setImageResource(R.drawable.no_camera);
        }
    }


    public PointModel getPm() {
        return pm;
    }
}