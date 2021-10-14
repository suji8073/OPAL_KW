package com.kw.opal;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserListAdapter extends BaseAdapter {

    final Context context;
    List<PointModel> pointList;
    ImageView image_tourism;
    Set<String> set = new HashSet<String>();
    String one, two, three, four;
    DbOpenHelper helper ;




    public UserListAdapter(Context context, List<PointModel> pointList) {
        this.context = context;
        this.pointList = pointList;



    }
    public void ListUpdate(List<PointModel> pointlist){
        this.pointList=pointlist;
        notifyDataSetChanged();
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
        View v = View.inflate(context, R.layout.user,null);
        TextView userID = (TextView)v.findViewById(R.id.name); // 관광지 이름
        TextView userPassword = (TextView)v.findViewById(R.id.id); //주소
        image_tourism  = (ImageView) v.findViewById(R.id.image_tourism); // 사진 띄우는 곳
        ImageView heart = (ImageView) v.findViewById(R.id.tourism_heart); //하트

        heart.setImageResource(R.drawable.heart_off);
        heart.setColorFilter(v.getResources().getColor(R.color.gray));




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


        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper = new DbOpenHelper(context);

                heart.setImageResource(R.drawable.heart_on);
                heart.setColorFilter(v.getResources().getColor(R.color.heart));


                one = String.valueOf(pointList.get(position).getName());
                two = String.valueOf(pointList.get(position).getAddr());
                three = String.valueOf(pointList.get(position).getImage());
                set.addAll(Collections.singleton(one));
                set.addAll(Collections.singleton(two));
                set.addAll(Collections.singleton(three));
                //set.addAll(Collections.singleton(String.valueOf(position)));

                helper.open();
                helper.insertColumn(position, one, three);


            }
        });


        //특정 user에 아이디값을 그대로 반환할수 있게 해준다
        v.setTag(pointList.get(position).getId());
        return v;

    }
    // 값 저장하기
    public void setReadCount(Set<String> set){
        SharedPreferences pref = context.getSharedPreferences("pref", MODE_PRIVATE);
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