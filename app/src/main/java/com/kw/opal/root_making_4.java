package com.kw.opal;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class root_making_4 extends root_making {
    public root_making_4() {
        this.layout = R.layout.root_making_4;
        this.search=R.id.editText;
        this.sbutton=R.id.search_button;
        this.userview = R.id.userListTextView4;
        this.cartv = R.id.cart;
        this.finishv = R.id.finish4;
        this.table = "shop";
        this.catlist = new ArrayList<>(Arrays.asList("all", "A04010200", "A04010100", "A04010900", "A04010700", "A04010800", "A04010600", "A04010300", "A04010400"));
        this.c_one = new Button[5];//TODO 동적처리 필요
        this.category = new Integer[]{R.id.one_1, R.id.one_2, R.id.one_3, R.id.one_4, R.id.one_5,R.id.one_6,R.id.one_7,R.id.one_8,R.id.one_9};
        this.on_off = new int[catlist.size()];
        this.spinner_field_id=R.id.spinner;
        this.TypeID="38";
    }
}

