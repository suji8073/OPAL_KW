package com.kw.opal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class rootDBOpenHelper {
    private static final String DATABASE_NAME = "root.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private rootDBOpenHelper.rDatabaseHelper mDBHelper;
    private Context mCtx;

    private class rDatabaseHelper extends SQLiteOpenHelper {


        public rDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(rootDataBases.CreateDB._CREATE1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+rootDataBases.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public rootDBOpenHelper(Context context){
        this.mCtx = context;
    }

    public rootDBOpenHelper open() throws SQLException {
        mDBHelper = new rootDBOpenHelper.rDatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void create(){
        mDBHelper.onCreate(mDB);
    }

    public void close(){
        mDB.close();
    }

    // Insert DB


    public void insertColumn( String a1,String a2,String a3,String a4,String area,String image) {
        // 중복 검사


        ContentValues values = new ContentValues();

        values.put(rootDataBases.CreateDB.A1, a1);
        values.put(rootDataBases.CreateDB.A2, a2);
        values.put(rootDataBases.CreateDB.A3, a3);
        values.put(rootDataBases.CreateDB.A4, a4);
        values.put(rootDataBases.CreateDB.AREA, area);
        values.put(rootDataBases.CreateDB.IMAGE, image);


        mDB.insertWithOnConflict(rootDataBases.CreateDB._TABLENAME0, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }
    // Update DB
    public boolean updateColumn (long id, String a1,String a2,String a3,String a4,String area,String image){
        ContentValues values = new ContentValues();

        values.put(rootDataBases.CreateDB.A1, a1);
        values.put(rootDataBases.CreateDB.A2, a2);
        values.put(rootDataBases.CreateDB.A3, a3);
        values.put(rootDataBases.CreateDB.A4, a4);
        values.put(rootDataBases.CreateDB.AREA, area);
        values.put(rootDataBases.CreateDB.IMAGE, image);

        return mDB.update(rootDataBases.CreateDB._TABLENAME0, values, "_id=" + id, null) > 0;
    }

    // Delete All
    public void deleteAllColumns () {
        mDB.delete(rootDataBases.CreateDB._TABLENAME0, null, null);
    }

    // Delete DB
    public boolean deleteColumn (String name){
        return mDB.delete(rootDataBases.CreateDB._TABLENAME0, "name=" + "'" + name + "'", null) > 0;
    }
    // Select DB
    public Cursor selectColumns () {
        return mDB.query(rootDataBases.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    // sort by column
    public Cursor sortColumn (){

        Cursor c = mDB.rawQuery("SELECT * FROM usertable;", null);
        return c;
    }
    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + "usertable";
        Cursor cursor = mDB.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
