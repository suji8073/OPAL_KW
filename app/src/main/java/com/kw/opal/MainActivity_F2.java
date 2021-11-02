package com.kw.opal;

import static org.apache.commons.lang3.StringUtils.isBlank;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity_F2 extends Fragment {
    SingerAdapter adapter;
    ArrayList<RouteModel> Rlist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    LinearLayout home, place, person;
    public SharedPreferences sroot, curcode;
    int root_num = 0;
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    reDBOpenHelper helper;
    Cursor mCur;
    Context context;
    Cursor mCur1;
    String img;

    int code;
    int cnt = 0;
    int next_page = 0;
    int incurcode;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(
                R.layout.newmain2_f, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        helper = new reDBOpenHelper(getActivity());
        mCur1=helper.sortColumn();
        adapter = new SingerAdapter();

        sroot = this.getActivity().getSharedPreferences("root", Activity.MODE_PRIVATE);
        curcode= this.getActivity().getSharedPreferences("code", Activity.MODE_PRIVATE);
        incurcode=curcode.getInt("code",0);


        ListView listView =  getActivity().findViewById(R.id.smart_root1);


        if (incurcode>0 && incurcode!=Rlist.size()){
            for(int i=0;i<incurcode;i++){
                /*if (i==1)
                    continue;*/

                mCur=helper.selectC(String.valueOf(i));
                System.out.println(mCur);
                mCur.moveToFirst();
                int id = R.drawable.no_camera;
                // 데이터베이스에 저장되어 있는 루트를 꺼내서 넣어야 함!
                if (!isBlank(mCur.getString(3)) ) {
                    img=mCur.getString(3);
                }
                else {img="";}
                mCur.moveToFirst();
                if (mCur != null&& mCur.moveToFirst() ) {
                    System.out.println(mCur.getString(1));
                    list.add(mCur.getString(2));
                    list.add("-");
                    while (mCur.moveToNext()) {
                        list.add(mCur.getString(2));

                        if (mCur.isLast() != true) {
                            list.add("-");
                        }
                    }
                }
                System.out.println(mCur);

                String title= TextUtils.join(" ", list);
                RouteModel r=new RouteModel(String.valueOf(i),title,img);
                Rlist.add(r);
                list.clear();
            }
            adapter.addItem(Rlist);
            listView.setAdapter(adapter);
        }

        adapter = new SingerAdapter();




    }
    class SingerAdapter extends BaseAdapter {
        ArrayList<RouteModel> items = new ArrayList<RouteModel>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ArrayList<RouteModel> item) {
            items.addAll(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용

            SingerItemView2 view = null;
            if (convertView == null) {
                view = new SingerItemView2(getActivity());

            } else {
                view = (SingerItemView2) convertView;
            }

            RouteModel item = items.get(position);
            view.setmodel(item);




            return view;
        }
    }

}
