package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.usermgmt.response.model.User;

import java.util.ArrayList;
import java.util.List;

public class root_making_1 extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<User> userList;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root_making_1);
        Intent intent = getIntent();
        //초기화를 해줘야지 실행이된다
        listView = (ListView) findViewById(R.id.userListTextView);
        userList = new ArrayList<User>();

        userList.add(new User("서울특별시1", "A0201", "http://tong.visitkorea.or.kr/cms/resource/88/2550988_image2_1.bmp", "경국사(서울)"));
        userList.add(new User("서울특별시1", "A0201", "http://tong.visitkorea.or.kr/cms/resource/88/2550988_image2_1.bmp", "경국사(서울)"));
        userList.add(new User("서울특별시1", "A0201", "http://tong.visitkorea.or.kr/cms/resource/88/2550988_image2_1.bmp", "경국사(서울)"));


        //어댑터 초기화부분 userList와 어댑터를 연결해준다.
        adapter = new UserListAdapter(getApplicationContext(), userList);
        listView.setAdapter(adapter);

    }

}