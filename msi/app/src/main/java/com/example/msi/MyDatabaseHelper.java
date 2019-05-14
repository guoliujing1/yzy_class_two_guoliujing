package com.example.msi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    /**
     * 建表
     * integer = int 整型
     * text 文本
     * blob 二进制
     * real 小数
     * */
    public static final String CREATE_BOOK = "create table Book("
            +"id integer primary key autoincrement,"
            +"author text,"
            +"price real,"
            +"pages integer,"
            +"name text,"
            +")";
    private Context mContext;
    /**
     * 构造函数
     * @param context -- 上下文
     * @param name -- 表名称
     * @param factory -- 数据库连接池
     * @param version -- 版本--用于数据更新--自定义
     * */
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
        //execute 执行SQL
        //创建数据库
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"数据库创建成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

    }
}
