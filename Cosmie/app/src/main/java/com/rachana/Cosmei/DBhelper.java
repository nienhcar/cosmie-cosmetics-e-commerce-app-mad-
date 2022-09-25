package com.rachana.Cosmei;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";
    private static final String TABLE_NAME = "cart";
    private static final String COL1 = "product";


    public DBhelper(Context context ) {
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key,password TEXT)");
        //MyDB.execSQL("create Table cart(product TEXT primary key )");
        String createTable = "CREATE TABLE " + TABLE_NAME + " (PRODUCT TEXT" +
                COL1 +" )";
        MyDB.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists TABLE_NAME");
    }
   public Boolean insertData(String username,String password) {
       SQLiteDatabase MyDB = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put("username", username);
       contentValues.put("password", password);
       long results = MyDB.insert("users", null, contentValues);
       if (results == -1) return false;
       else
           return true;

   }
   public Boolean addData(String product){
       SQLiteDatabase MyDB = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(COL1, product);
       Log.d(null, "addData: Adding " +product+ " to " + TABLE_NAME);

       long results1 = MyDB.insert(TABLE_NAME, null, contentValues);

       if (results1 == -1) return false;
       else
           return true;
    }
    public Cursor getData(){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = MyDB.rawQuery(query, null);
        return data;
    }

   public boolean checkusername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
       Cursor cursor=MyDB.rawQuery("Select * from users where username =?",new String[] {username});
       if(cursor.getCount()>0)
           return true;
       else
           return false;
   }

    public boolean checkusernamepassword(String username,String password) {
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username =? and password=?",new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    }