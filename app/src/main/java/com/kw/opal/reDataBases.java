package com.kw.opal;

import android.provider.BaseColumns;

public class reDataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String _ID = "id";
        public static final String USERID = "userid";
        public static final String NAME = "name";
        public static final String ADDR = "addr2";
        public static final String MAP_X = "x";
        public static final String  MAP_Y = "y";
        public static final String IMAGE = "image";
        public static final String _TABLENAME0 = "recommend";
        public static final String CODE = "code";
        public static final String AREA = "area";

        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null , "
                +NAME+" text not null , "
                +IMAGE+" text not null ,"
                +ADDR+" text not null , "
                +MAP_X+" text not null , "
                +MAP_Y+" text not null , "
                +CODE+" text not null , "

                +AREA+" text not null );";
    }
}
