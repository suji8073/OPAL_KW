package com.kw.opal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
public class login extends AppCompatActivity {


    private Button btn_custom_login;
    private Button btn_custom_login_out;
    TextView login_non;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HashMap<String, Object> param = new HashMap<>();
        //Log.i("해시", Utility.INSTANCE.getKeyHash(this));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login_non = (TextView) findViewById(R.id.login_non);
        ImageButton loginKakao = findViewById(R.id.btn_kakao_login);
        loginKakao.setOnClickListener(view-> kakaoTalkLogin());


        login_non.setOnClickListener(view -> {
            Intent start_intent = new Intent(login.this, MainActivity.class);
            start_intent.putExtra("login_check", 0);
            start_intent.putExtra("name", "0");
            startActivity(start_intent);

        });


    }

    protected void kakaoTalkLogin() {

        UserApiClient.getInstance().loginWithKakaoTalk(this, ( token, error) ->{
            if (error != null) {
                Log.e("test", "로그인 실패", error);
            }
            else if (token != null) {
                Log.i("test", "로그인 성공 ${token.accessToken}");
                getKakaoInfoPermission();
            }
            return null;
        });



    }

    protected void getKakaoInfoPermission(){
        UserApiClient.getInstance().me(
                (user, error) -> {
                    List<String> scopes = new ArrayList<>();
                    if (error != null) {
                        Log.e("로그인", "사용자 정보 요청 실패", error);
                    } else if (user != null) {

                        if (user.getKakaoAccount() != null) {
                            if (user.getKakaoAccount().getProfileImageNeedsAgreement() == null ||user.getKakaoAccount().getProfileImageNeedsAgreement()) {
                                scopes.add("profile");
                            }
                        }
                    }
                    Log.e("로그인", String.valueOf(scopes.size()));
                    if (!scopes.isEmpty()) {
                        Log.d("로그인", "사용자에게 추가 동의를 받아야 합니다.");
                        UserApiClient.getInstance().loginWithNewScopes(this, scopes, null, (token, error1) -> {
                                    if (error1 != null) {
                                        Log.e("로그인", "사용자 추가 동의 실패", error1);
                                    } else if (token != null) {
                                        Log.d("로그인", "allowed scopes: " + token.getScopes().toString());

                                        // 사용자 정보 재요청
                                        UserApiClient.getInstance().me((user1, error11) -> {
                                            if (error11 != null) {
                                                Log.e("로그인", "사용자 정보 요청 실패", error11);
                                            } else if (user1 != null) {
                                                getKakaoInfo();
                                            }
                                            return null;
                                        });
                                    }
                                    return null;
                                }

                        );
                    }else{
                        getKakaoInfo();

                    }

                    return null;
                }
        );
    }

    protected void getKakaoInfo(){
        UserApiClient.getInstance().me( (user, error) -> {
                    if (error != null) {
                        Log.e("로그인", "사용자 정보 요청 실패", error);
                    }
                    else if (user != null) {
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.putExtra("login_check", 1);
                        intent.putExtra("name", user.getKakaoAccount().getProfile().getNickname());
                        intent.putExtra("profile", user.getKakaoAccount().getProfile().getProfileImageUrl());

                        startActivity(intent);
                        finish();
                    }
                    return null;
                }
        );
    }
}