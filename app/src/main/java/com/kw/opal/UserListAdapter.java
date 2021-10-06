package com.kw.opal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.kakao.usermgmt.response.model.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class UserListAdapter extends BaseAdapter {

    final Context context;
    final List<PointModel> pointList;
    private ImageView ivimage;
    

    public UserListAdapter(Context context, List<PointModel> pointList) {
        this.context = context;
        this.pointList = pointList;
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
        TextView userID = (TextView)v.findViewById(R.id.name);
        TextView userPassword = (TextView)v.findViewById(R.id.id);
        TextView userName = (TextView)v.findViewById(R.id.addr);
        ivimage  = (ImageView) v.findViewById(R.id.image121);
        int id=R.drawable.check_on;
        if (pointList.get(position).getImage()==null){
            System.out.println(pointList.get(position).getImage());
            ivimage.setImageResource(id);
        }
        else{
            new DownloadFilesTask().execute(pointList.get(position).getImage());

        }

        userID.setText(pointList.get(position).getName());
        userPassword.setText(pointList.get(position).getAddr());
        userName.setText(pointList.get(position).getImage());

        //userAge.setText(pointList.get(position).getId());


        //특정 user에 아이디값을 그대로 반환할수 있게 해준다
        v.setTag(pointList.get(position).getId());
        return v;

    }
    private class DownloadFilesTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmp = null;
            try {
                String img_url = strings[0]; //url of the image
                URL url = new URL(img_url);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            // doInBackground 에서 받아온 total 값 사용 장소
            ivimage.setImageBitmap(result);
        }
    }

}