package com.kw.opal;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserListAdapter2 extends BaseAdapter {

    final Context context;
    List<PointModel> pointList;
    ImageView image_tourism;
    String TypeID;




    public UserListAdapter2(Context context, List<PointModel> pointList) {
        this.context = context;
        this.pointList = pointList;



    }
    public List getList(){
        return this.pointList;
    }
    public void ListUpdate(List<PointModel> pointlist){
        this.pointList=pointlist;
        notifyDataSetChanged();
    }
    public void setTypeID(String Type){
        this.TypeID=Type;
    }



    @Override
    public int getCount() {
        //현재사용자의 개수 반환
        return pointList.size();
    }

    @Override
    public Object getItem(int position) {
        return pointList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //그대로 반환
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //하나의 사용자에대한 view를 보여주는 부분
        //한명의 사용자에대한 view가 만들어진다.

        View v = View.inflate(context, R.layout.routepoint,null);
        TextView userID = (TextView)v.findViewById(R.id.name); // 관광지 이름
        TextView userPassword = (TextView)v.findViewById(R.id.id); //주소
        image_tourism  = (ImageView) v.findViewById(R.id.image_tourism); // 사진 띄우는 곳


        LinearLayout inform = (LinearLayout)v.findViewById(R.id.pointinform);



        inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_intent = new Intent(context, tourism.class);
                start_intent.putExtra("Id",pointList.get(position).getId());
                start_intent.putExtra("TypeId",pointList.get(position).getContentTypeId());
                context.startActivity(start_intent.addFlags(FLAG_ACTIVITY_NEW_TASK));
            }
        });




        int id = R.drawable.no_camera;
        if (pointList.get(position).getImage() == null){
            System.out.println(pointList.get(position).getImage());
            image_tourism.setImageResource(id);
        }
        else{
            Glide.with(context).load(pointList.get(position).getImage()).into(image_tourism);

        }

        userID.setText(pointList.get(position).getName());
        userPassword.setText(pointList.get(position).getAddr());
        //userName.setText(pointList.get(position).getImage());
        //userAge.setText(pointList.get(position).getId());
        ArrayList<String> arrayData = new ArrayList<String>();

        //특정 user에 아이디값을 그대로 반환할수 있게 해준다
        v.setTag(pointList.get(position).getId());
        return v;

    }
    // 값 저장하기
    public void setReadCount(Set<String> set){
        SharedPreferences pref = context.getSharedPreferences("sroot", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putStringSet("pref", set);
        Log.d("하트 들어가는 지 확인", String.valueOf(set));

    }
//
//    private class DownloadFilesTask extends AsyncTask<String, Void, Bitmap> {
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//            Bitmap bmp = null;
//            try {
//                String img_url = strings[0]; //url of the image
//                URL url = new URL(img_url);
//                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return bmp;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            // doInBackground 에서 받아온 total 값 사용 장소
//            image_tourism.setImageBitmap(result);
//        }
//    }
//
}