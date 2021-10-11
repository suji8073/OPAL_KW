package com.kw.opal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class root_making_3 extends root_making {
    public root_making_3(){
        this.layout =R.layout.root_making_3;
        this.userview=R.id.userListTextView3;
        this.cartv = R.id.cart;
        this.finishv = R.id.finish3;
        this.table = "hotel";
        this.catlist= new ArrayList<>(Arrays.asList("all","A03020200","B02010100","B02010200","B02010300","B02010400","B02010500","B02010600","B02010700","B02010800","B02010900","B02011000","B02011100","B02011200","B02011300","B02011400","B02011500","B02011600"));
        this.c_one=new Button[5];
        this.category = new Integer[]{R.id.one_1, R.id.one_2, R.id.one_3, R.id.one_4, R.id.one_5};
        this.on_off = new int[catlist.size()];
    }
}
