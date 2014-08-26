package com.example.datastore;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author TechBirds
 * @date 14-8-26
 * @time 上午11:56
 * @vsersion 1.0
 */
public class AppSQLiteHelper extends SQLiteOpenHelper {

    public static final String USER_TABLE = "user";
    public static final String CATEGORY_TABLE = "category";

    private static final String CREATE_USER = " CREATE TABLE user ("
            + "id integer primary key autoincrement, "
            + "name text, "
            + "password text, "
            + "created_date datetime ) ";

    private static final String CREATE_CATEGORY = " CREATE TABLE category ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "created_date datetime ) ";

    public static final int version = 1;
    public static final String dbName = "test";

    /**
     * @param context
     * @param name 数据库名称
     * @param factory 查询返回一个自定义的Cursor
     * @param version 数据库版本
     */
    public AppSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AppSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newOldVersion) {

        // 升级数据库
        switch (oldVersion){
            case 1:
                sqLiteDatabase.execSQL(CREATE_CATEGORY);
                break;
            case 2:
                // 一些其他数据变更需求
                break;
            default:
                break;
        }
    }
}
