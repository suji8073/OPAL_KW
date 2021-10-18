package com.kw.opal;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String _ID = "id";
        public static final String USERID = "userid";
        public static final String NAME = "name";
        public static final String ADDR = "addr2";
        public static final String MAP_X = "x";
        public static final String  MAP_Y = "y";
        public static final String IMAGE = "image";
        public static final String _TABLENAME0 = "usertable";
        public static final String AREA = "area";


        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null , "

                +NAME+" text not null , "
                +IMAGE+" text not null ,"
                +ADDR+" text not null , "
                +MAP_X+" text not null , "
                +MAP_Y+" text not null , "

                +AREA+" text not null );";
    }
}

