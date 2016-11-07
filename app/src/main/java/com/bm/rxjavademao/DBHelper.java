package com.bm.rxjavademao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hecl on 2016/11/2.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper dbHelper;
    //类没有实例化,是不能用作父类构造器的参数,必须声明为静态
    private static final String NAME = "SQLITE.db"; //数据库名称
    private static final int version = 1; //数据库版本
    public static final String TABLE_NAME = "person";//表名
    /**
     * 插入数据的的表名和一下字段
     * */
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "age TEXT," +
                    "sex TEXT)";

    public DBHelper(Context context) {
        super(context, NAME, null, version);
    }

    public static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);//创建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
