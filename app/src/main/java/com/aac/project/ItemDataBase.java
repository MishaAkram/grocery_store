package com.aac.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ItemDataBase extends SQLiteOpenHelper {
    SQLiteDatabase database;

    public static final String DATABASE_NAME="items.db";
    public static final String TABLE_NAME1="fruit_table";
    public static final String TABLE_NAME2="vegetable_table";
    public static final String TABLE_NAME3="meat_table";
    public static final String TABLE_NAME4="bakeryitems_table";

    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="PRICE";

    public static final int DATABASE_VERSION=1;

    public ItemDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE REAL)");
        db.execSQL("create table " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE REAL)");
        db.execSQL("create table " + TABLE_NAME3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE REAL)");
        db.execSQL("create table " + TABLE_NAME4 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PRICE REAL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getfruitData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME1,null);
        return res;}

    public Cursor getvegetableData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;}

    public Cursor getmeatData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME3,null);
        return res;}

    public Cursor getbakeryData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME4,null);
        return res;}


}
