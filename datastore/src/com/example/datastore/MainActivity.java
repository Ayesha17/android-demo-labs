package com.example.datastore;

import android.app.Activity;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import com.example.datastore.vo.User;

import java.util.List;

public class MainActivity extends Activity {

    private AppSQLiteHelper appSQLiteHelper;

    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        appSQLiteHelper = new AppSQLiteHelper(this,AppSQLiteHelper.dbName,null,AppSQLiteHelper.version);

    }

    /**
     * 大致读取流程
     */
    public void testSharedPreferences(){
        SharedPreferences sharedPreferences = SharedPreferencesDataStoreUtil.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username","xxxxx");
        editor.putString("password",".....");
        editor.commit();
    }


    /**
     * SQLite大致操作流程
     */
    public void testAppSQLiteHelper(){
        // 如果指定数据库不存在，则自动创建
        SQLiteDatabase sqLiteDatabase = appSQLiteHelper.getWritableDatabase();
    }


    public void testInsertUser(SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","TechBirds");
        contentValues.put("password", "123456");
        database.replace(AppSQLiteHelper.USER_TABLE, null, contentValues);
    }

    /**
     * 批量插入方式一(借助contentValues)
     * @param database
     * @param users
     */
    public void testBatchInsertUser1(SQLiteDatabase database,List<User> users){
        database.beginTransaction();
        for (User user : users){
            ContentValues contentValues = new ContentValues();
            contentValues.put("username",user.getUsername());
            contentValues.put("password",user.getPwd());
            database.replace(AppSQLiteHelper.USER_TABLE, null, contentValues);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /**
     * 将需要批量插入的数据格式化为统一的sql
     * @param database
     * @param sqlStrings
     */
    public void testBatchInsertUser2(SQLiteDatabase database,List<String> sqlStrings){
        database.beginTransaction();
        for (String sql : sqlStrings){
            database.execSQL(sql);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /**
     * InsertHelper类(API > 17)已废弃，替换。效率最高，耗时最短
     * @param database
     * @param users
     */
    public void testBatchInsertUser3(SQLiteDatabase database,List<User> users){

        String sql = "replace into " + AppSQLiteHelper.USER_TABLE + "(username,password) VALUES(?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        database.beginTransaction();
        for(User user : users){
            statement.bindString(1,user.getUsername());
            statement.bindString(2,user.getPwd());
            statement.executeInsert();
        }
        database.endTransaction();
    }


    public void testUpdateUser(SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","wangDong");
        database.update(AppSQLiteHelper.USER_TABLE,contentValues,"name = ?",new String[]{"TechBirds"});
        database.close();
    }

    public void testDeleteUser(SQLiteDatabase database){
        database.delete(AppSQLiteHelper.USER_TABLE,"name = ?" , new String[]{"TechBirds"});
    }

    /**
     * 查询,正常关闭cursor(隐患)
     * @param database
     */
    public void testQueryUser1(SQLiteDatabase database){
        Cursor cursor = database.query(AppSQLiteHelper.USER_TABLE,new String[]{"name","password"},"name = TechBirds",null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String password = cursor.getString(cursor.getColumnIndex("password"));

                Log.d(TAG,"name :" + name);
                Log.d(TAG,"password :" + password);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

    /**
     * 查询,异常捕获来关闭cursor
     * @param database
     */
    public void testQueryUser2(SQLiteDatabase database){

        Cursor cursor = database.query(AppSQLiteHelper.USER_TABLE,new String[]{"name","password"},"name = TechBirds",null,null,null,null);
        try{

            if(cursor.moveToFirst()){
                do {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String password = cursor.getString(cursor.getColumnIndex("password"));

                    Log.d(TAG,"name :" + name);
                    Log.d(TAG,"password :" + password);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }
    }

}
