package com.kw.opal;

import android.app.Application;
import android.content.Context;

import com.kakao.sdk.common.KakaoSdk;


public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    public static GlobalApplication getGlobalApplicationContext() {
        if (instance == null) {
            throw new IllegalStateException("This Application does not inherit com.kakao.GlobalApplication");
        }

        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSdk.init(this,BuildConfig.KAKAO_KEY);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }




}