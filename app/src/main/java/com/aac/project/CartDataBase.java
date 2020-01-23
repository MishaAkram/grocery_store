package com.aac.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CartDataBase extends SQLiteOpenHelper {
    SQLiteDatabase database;

    public static final String DATABASE_NAME="cart.db";
    public static final String TABLE_NAME="item_table";
    public static final String TABLE_NAME1="custumer_table";

    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="PRICE";
    public static final String COL4="CALCULATED_PRICE";

    public static final String COLM1="ID";
    public static final String COLM2="NAME";
    public static final String COLM3="PHONE";
    public static final String COLM4="ADDRESS";

    public static final int DATABASE_VERSION=3;

    public CartDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        SQLiteDatabase database = this.getWritableDatabase();
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT ,PRICE INT ,CALCULATED_PRICE INT )");
        db.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT ,PHONE TEXT ,ADDRESS TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public boolean insertitem(String name ,int price ,int calculatedprice ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3,price);
        contentValues.put(COL4,calculatedprice);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
            return  true;

    }

    public boolean insertdata(String name ,String phone ,String address ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLM2, name);
        contentValues.put(COLM3, phone);
        contentValues.put(COLM4, address);

        long result = db.insert(TABLE_NAME1, null, contentValues);
        if (result == -1) {
            return false;
        } else
            return true;
    }

        public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

        }
//public int getSumValue(){
//        int sum=0;
//        SQLiteDatabase db=this.getReadableDatabase();
//        //String sumQuery=String.format( "SELECT SUM(%s) as Total FROM %s" , TABLE_NAME);
//        String sumQuery=String.format( "SELECT SUM(CALCULATED_PRICE) FROM TABLE_NAME" , TABLE_NAME);
//        Cursor cursor=db.rawQuery(sumQuery,null);
//        if(cursor.moveToFirst())
//        sum= cursor.getInt(cursor.getColumnIndex("Total"));
//        return sum ;
//        }
        }
