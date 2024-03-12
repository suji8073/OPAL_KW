package com.kw.opal;

import android.provider.BaseColumns;

public class rootDataBases {
    public static final class CreateDB implements BaseColumns {

        public static final String A1 = "a1";
        public static final String A2 = "a2";
        public static final String A3 = "a3";
        public static final String A4 = "a4";
        public static final String AREA = "area";
        public static final String IMAGE = "image";


        public static final String _TABLENAME0 = "usertable";

        public static final String _CREATE1 = "create table if not exists "+_TABLENAME0+"("
                +A1+" text not null , "
                +A2+" text not null , "
                +A3+" text not null , "

                +A4+" text not null , "
                +AREA+" text not null , "

                +IMAGE+" text not null );";
    }
}
