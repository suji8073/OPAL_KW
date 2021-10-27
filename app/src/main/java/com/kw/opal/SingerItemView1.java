package com.kw.opal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingerItemView1 extends LinearLayout {

    TextView textView;
    TextView textView2;


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

        textView = (TextView) findViewById(R.id.smart_area);
        textView2 = (TextView) findViewById(R.id.smart_root);

    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }



}