package com.kw.opal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class reDBOpenHelper {
    private DbOpenHelper helper;


    private static final String DATABASE_NAME = "recommend.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private reDBOpenHelper.DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper{


        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(reDataBases.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+reDataBases.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public reDBOpenHelper(Context context){
        this.mCtx = context;
    }

    public reDBOpenHelper open() throws SQLException{
        mDBHelper = new reDBOpenHelper.DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
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


    public void insertColumn(Integer userid, String name, String image, String addr2, double x, double y) {
        // 중복 검사



            ContentValues values = new ContentValues();
            values.put(reDataBases.CreateDB.USERID, userid);
            values.put(reDataBases.CreateDB.NAME, name);
            values.put(reDataBases.CreateDB.IMAGE, image);
            values.put(reDataBases.CreateDB.ADDR, addr2);
            values.put(reDataBases.CreateDB.MAP_X, x);
            values.put(reDataBases.CreateDB.MAP_Y, y);


            mDB.insertWithOnConflict(reDataBases.CreateDB._TABLENAME0, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }
    // Update DB
    public boolean updateColumn ( long id, String name, String image, String addr2,double x,
                                  double y){
        ContentValues values = new ContentValues();
        values.put(reDataBases.CreateDB.USERID, id);
        values.put(reDataBases.CreateDB.NAME, name);
        values.put(reDataBases.CreateDB.IMAGE, image);
        values.put(reDataBases.CreateDB.ADDR, addr2);
        values.put(reDataBases.CreateDB.MAP_X, x);
        values.put(reDataBases.CreateDB.MAP_Y, y);
        return mDB.update(reDataBases.CreateDB._TABLENAME0, values, "_id=" + id, null) > 0;
    }

    // Delete All
    public void deleteAllColumns () {
        mDB.delete(reDataBases.CreateDB._TABLENAME0, null, null);
    }

    // Delete DB
    public boolean deleteColumn (String name){
        return mDB.delete(reDataBases.CreateDB._TABLENAME0, "name=" + "'" + name + "'", null) > 0;
    }
    // Select DB
    public Cursor selectColumns () {
        return mDB.query(reDataBases.CreateDB._TABLENAME0, null, null, null, null, null, null);
    }

    // sort by column
    public Cursor sortColumn (String sort){

        Cursor c = mDB.rawQuery("SELECT * FROM recommend ORDER BY " + sort + ";", null);
        return c;


    }
}
