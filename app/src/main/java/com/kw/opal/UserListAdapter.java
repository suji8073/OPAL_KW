package com.kw.opal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kakao.usermgmt.response.model.User;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    final Context context;
    final List<User> userList;

    

    public UserListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }


    @Override
    public int getCount() {
        //현재사용자의 개수 반환
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
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
        TextView userAge = (TextView)v.findViewById(R.id.addr2);

        userID.setText(userList.get(position).getUserID());
        userPassword.setText(userList.get(position).getUserPassword());
        userName.setText(userList.get(position).getUserName());
        userAge.setText(userList.get(position).getUserAge());

        //특정 user에 아이디값을 그대로 반환할수 있게 해준다
        v.setTag(userList.get(position).getUserID());
        return v;

    }
}