package com.kw.opal;

import android.provider.BaseColumns;

public class rootDataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String _ID = "userid";
        public static final String A1 = "a1";
        public static final String A2 = "a2";
        public static final String A3 = "a3";
        public static final String A4 = "a4";
        public static final String _TABLENAME0 = "usertable";

        public static final String _CREATE1 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +A1+" integer not null , "
                +A2+" integer not null , "
                +A3+" integer not null , "
                +A4+" integer not null );";
    }
}
