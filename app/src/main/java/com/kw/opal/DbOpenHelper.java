package com.kw.opal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {
    private DbOpenHelper helper;


    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper{


        public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DataBases.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME0);
            onCreate(db);
        }
    }

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException{
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
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


    public void insertColumn(Integer userid, String name,String image, String addr2, Float x, Float y, String area,String typeid) {
        // 중복 검사


        Cursor curChk = mDB.rawQuery("SELECT * FROM usertable WHERE USERID="+"'" + userid +"'"+ ";", null);

        if (curChk.moveToFirst()) {
            System.out.println("out");

        }
        else{
            ContentValues values = new ContentValues();
            values.put(DataBases.CreateDB.USERID, userid);

            values.put(DataBases.CreateDB.NAME, name);

            values.put(DataBases.CreateDB.IMAGE, image);
            values.put(DataBases.CreateDB.ADDR, addr2);
            values.put(DataBases.CreateDB.MAP_X, x);
            values.put(DataBases.CreateDB.MAP_Y, y);
            values.put(DataBases.CreateDB.AREA, area);
            values.put(DataBases.CreateDB.TYPEID, typeid);


            mDB.insertWithOnConflict(DataBases.CreateDB._TABLENAME0, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        }}
        // Update DB
        public boolean updateColumn ( long id,String name, String image, String addr2,float x,
        float y, String area,String typeid){
            ContentValues values = new ContentValues();
            values.put(DataBases.CreateDB.USERID, id);
            values.put(DataBases.CreateDB.NAME, name);
            values.put(DataBases.CreateDB.IMAGE, image);

            values.put(DataBases.CreateDB.ADDR, addr2);
            values.put(DataBases.CreateDB.MAP_X, x);
            values.put(DataBases.CreateDB.MAP_Y, y);
            values.put(DataBases.CreateDB.AREA, area);
            values.put(DataBases.CreateDB.TYPEID, typeid);

            return mDB.update(DataBases.CreateDB._TABLENAME0, values, "_id=" + id, null) > 0;
        }

        // Delete All
        public void deleteAllColumns () {
            mDB.delete(DataBases.CreateDB._TABLENAME0, null, null);
        }

        // Delete DB
        public boolean deleteColumn (String name){
            return mDB.delete(DataBases.CreateDB._TABLENAME0, "name=" + "'" + name + "'", null) > 0;
        }
        // Select DB
        public Cursor selectColumns () {
            return mDB.query(DataBases.CreateDB._TABLENAME0, null, null, null, null, null, null);
        }

        // sort by column
        public Cursor sortColumn (String sort){

            Cursor c = mDB.rawQuery("SELECT * FROM usertable ORDER BY " + sort + ";", null);
            return c;


        }
    public Cursor sortColumn2 (){

        Cursor c = mDB.rawQuery("SELECT * FROM usertable ;", null);
        return c;


    }
        public Cursor sortColumn1 (String sort){

            Cursor c = mDB.rawQuery("SELECT "+sort+" FROM usertable ;", null);
            return c;


        }

    }
