package com.example.book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table user(id integer primary key autoincrement,user text, pass text)";
    public static final String CREATE_BOOK = "create table Book(name text primary key,price real,author text,pages integer)";
    private Context mContext;
    public MyDatabaseHelper(
            Context context,
            String name,
            SQLiteDatabase.CursorFactory factory,
            int version){
        super(context,name,factory,version);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_BOOK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        //如果表存在则删除以后重新创建
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists user");
        //执行创建动作
        onCreate(db);
    }
}

