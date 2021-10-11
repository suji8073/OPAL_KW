package com.kw.opal;


import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class root_making_1 extends root_making {

    public root_making_1(){
        this.layout =R.layout.root_making_1;
        this.userview=R.id.userListTextView1;
        this.cartv = R.id.cart;
        this.finishv = R.id.finish1;
        this.table = "city";
        this.catlist= new ArrayList<>(Arrays.asList("all","A0101","A0102","A0201","A0202","A0203","A0204","A0205","A0302"));
        this.c_one=new Button[5];
        this.category = new Integer[]{R.id.one_1, R.id.one_2, R.id.one_3, R.id.one_4,R.id.one_5,R.id.one_6,R.id.one_7,R.id.one_8,R.id.one_9};
        this.on_off = new int[catlist.size()];
    }

}

