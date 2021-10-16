package com.kw.opal;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class root_making_2 extends root_making {

    public root_making_2(){
        this.layout =R.layout.root_making_2;
        this.search=R.id.editText;
        this.sbutton=R.id.search_button;
        this.userview=R.id.userListTextView2;
        this.cartv = R.id.cart;
        this.finishv = R.id.finish2;
        this.table = "food";
        this.catlist= new ArrayList<>(Arrays.asList("all","A05020100","A05020200","A05020300","A05020400","A05020500","A05020600","A05020700","A05020800","A05020900"));
        this.c_one=new Button[5];
        this.category = new Integer[]{R.id.one_1, R.id.one_2, R.id.one_3, R.id.one_4, R.id.one_5};
        this.on_off = new int[catlist.size()];
        this.spinner_field_id=R.id.spinner;
    }
}

