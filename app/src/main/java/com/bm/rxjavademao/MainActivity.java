package com.bm.rxjavademao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/**
 *
 * */
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = DBHelper.getInstance(MainActivity.this);
                SQLiteDatabase database = helper.getWritableDatabase();//以写方式打开数据库
                ContentValues values = new ContentValues();
                values.put("name", "阿龙");
                values.put("age", "25");
                values.put("sex", "男");
                database.insert(DBHelper.TABLE_NAME, null, values);//插入数据
                database.close();//关闭SQLiteDatabase
            }
        });
        /**
         *
         * */
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = DBHelper.getInstance(MainActivity.this);
                SQLiteDatabase database = helper.getReadableDatabase();//以读方式打开数据库
                /**
                 * 查询全部的数据，在rawQuery中必须要加select * from
                 * 注意select * from 后面必须要有空格
                 * */
               Cursor c = database.rawQuery("select * from "+DBHelper.TABLE_NAME, null);
                /**
                 *增加查询条件 有汉字汉字必须加单引号
                 * */
//                Cursor c = database.rawQuery("select * from " + DBHelper.TABLE_NAME
//                        + " where name = '小王' and age = 30", null);
                while (c.moveToNext()) {
                    System.out.println(">>>>>>>>id>" + c.getString(c.getColumnIndex("id")));
                    System.out.println(">>>>>>>>name>" + c.getString(c.getColumnIndex("name")));
                    System.out.println(">>>>>>>>age>" + c.getString(c.getColumnIndex("age")));
                    System.out.println(">>>>>>>>sex>" + c.getString(c.getColumnIndex("sex")));
                }
                database.close();//关闭
            }
        });
        /**
         *
         * */
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = DBHelper.getInstance(MainActivity.this);
                SQLiteDatabase database = helper.getWritableDatabase();//以写方式打开数据库
                //删除插入的某一条数据
                database.delete(DBHelper.TABLE_NAME, "id = 2", null);
                database.close();//查询完了要关闭SQLiteOpenHelper
            }
        });

        /**
         *
         * */
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper helper = DBHelper.getInstance(MainActivity.this);
                SQLiteDatabase database = helper.getWritableDatabase();//以读写方式打开数据库
                ContentValues values = new ContentValues();
                values.put("name", "小里");
                /**
                 * 修改插入的某一条数据 values必填
                 * "id = 6 and age = 30"  ：修改条件
                 * */
                database.update(DBHelper.TABLE_NAME, values, "id = 6 and age = 30", null);
                database.close();//查询完了要关闭SQLiteOpenHelper
            }
        });
    }

}
