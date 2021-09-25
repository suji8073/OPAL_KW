package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ApiErrorCode;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.OptionalBoolean;
import com.kakao.util.exception.KakaoException;

public class login extends AppCompatActivity {

    private Button btn_custom_login;
    private Button btn_custom_login_out;
    private SessionCallback sessionCallback;
    Session session;
    TextView login_non;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login_non = (TextView) findViewById(R.id.login_non);

        sessionCallback = new SessionCallback();
        Session.getCurrentSession().addCallback(sessionCallback);

        //Session.getCurrentSession().checkAndImplicitOpen(); //자동 로그인



        login_non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_intent = new Intent(login.this, com.kw.opal.MainActivity.class);
                start_intent.putExtra("login_check", 0);
                start_intent.putExtra("name", "0");
                startActivity(start_intent);

            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) { //카카오 로그인 액티비티에서 넘어온 경우일 때 실행
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
    }

    public class SessionCallback implements ISessionCallback {


        @Override
        public void onSessionOpened() {
            //로그인 세션이 열렸을 때

            requestMe();
        }


        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            // 로그인 세션이 열리지 않았을 때
            Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());


        }

        // 사용자 정보 요청
        public void requestMe() {
            UserManagement.getInstance()
                    .me(new MeV2ResponseCallback() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                            Toast.makeText(getApplicationContext(),"세션이 닫혔습니다. 다시 시도해 주세요: "+ errorResult.getErrorMessage(),Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            int result = errorResult.getErrorCode();
                            Log.e("KAKAO_API", "사용자 정보 요청 실패: " + errorResult);

                            if(result == ApiErrorCode.CLIENT_ERROR_CODE) {
                                Toast.makeText(getApplicationContext(), "네트워크 연결이 불안정합니다. 다시 시도해 주세요.", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(),"로그인 도중 오류가 발생했습니다: "+errorResult.getErrorMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }


                        @Override
                        public void onSuccess(MeV2Response result) {
                            //로그인에 성공했을 때
                            Log.i("KAKAO_API", "사용자 아이디: " + result.getId());

                            UserAccount kakaoAccount = result.getKakaoAccount();
                            if (kakaoAccount != null) {

                                // 이메일
                                String email = kakaoAccount.getEmail();

                                if (email != null) {
                                    Log.i("KAKAO_API", "email: " + email);

                                } else if (kakaoAccount.emailNeedsAgreement() == OptionalBoolean.TRUE) {
                                    // 동의 요청 후 이메일 획득 가능
                                    // 단, 선택 동의로 설정되어 있다면 서비스 이용 시나리오 상에서 반드시 필요한 경우에만 요청해야 합니다.

                                } else {
                                    // 이메일 획득 불가
                                }

                                // 프로필
                                Profile profile = kakaoAccount.getProfile();

                                if (profile != null) {
                                    Log.d("KAKAO_API", "nickname: " + profile.getNickname());
                                    Log.d("KAKAO_API", "profile image: " + profile.getProfileImageUrl());
                                    Log.d("KAKAO_API", "thumbnail image: " + profile.getThumbnailImageUrl());

                                } else if (kakaoAccount.profileNeedsAgreement() == OptionalBoolean.TRUE) {
                                    // 동의 요청 후 프로필 정보 획득 가능

                                } else {
                                    // 프로필 획득 불가
                                }
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("login_check", 1);
                                intent.putExtra("name", profile.getNickname());
                                //intent.putExtra("profile", profile.getThumbnailImageUrl());
                                startActivity(intent);
                                finish();
                            }




                        }
                    });
        }


    }

}