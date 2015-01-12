package com.example.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import org.androidannotations.annotations.*;

/**
 * @author TechBirds
 * @date 14-12-15
 * @time 上午11:42
 * @vsersion 1.0
 */
@EActivity(R.layout.matrix)
public class MatrixActivity extends Activity {

    @ViewById
    ImageView iv1;

    @ViewById
    ImageView iv2;

    @ViewById
    Button btn1;

    @ViewById
    Button btn2;

    @ViewById
    Button btn3;

    @ViewById
    Button btn4;

    @ViewById
    Button btn5;

    Bitmap bitmap = null;

    /**
     * 加载完View之后进行的处理
     */
    @AfterViews
    void afterViewProcess() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lena);

    }

    @Click
    void btn1() {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        iv2.setImageBitmap(bm);
        showToast(matrix);
    }

    @UiThread
    void showToast(Matrix matrix) {
        String string = "";
        float[] values = new float[9];
        matrix.getValues(values);
        for (int i = 0; i < values.length; i++) {
            string += "matrix.at" + i + "=" + values[i];
        }
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
        Log.d("TEST", string);
    }

    @Click
    void btn2() {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);// 缩小为原来的一半
        matrix.postRotate(45.0f);// 旋转45度 == matrix.setSinCos(0.5f, 0.5f);
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        iv2.setImageBitmap(bm);
        showToast(matrix);
    }

    @Click
    void btn3() {
        Matrix matrix = new Matrix();
        matrix.setTranslate(bitmap.getWidth() / 2, bitmap.getHeight() / 2);// 向左下平移
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        iv2.setImageBitmap(bm);
        showToast(matrix);
    }

    @Click
    void btn4() {
        Matrix matrix = new Matrix();
        matrix.setSkew(0.5f, 0.5f);// 斜切
        matrix.postScale(0.5f, 0.5f);// 缩小为原来的一半
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        iv2.setImageBitmap(bm);
        showToast(matrix);
    }

    /**
     * 相当于自由变换
     */
    @Click
    void btn5() {
        Matrix matrix = new Matrix();
        float[] src = new float[] { 0, 0, // 左上
                bitmap.getWidth(), 0,// 右上
                bitmap.getWidth(), bitmap.getHeight(),// 右下
                0, bitmap.getHeight() };// 左下
        float[] dst = new float[] { 0, 0,
                bitmap.getWidth(), 30,
                bitmap.getWidth(), bitmap.getHeight() - 30,
                0,bitmap.getHeight() };
        matrix.setPolyToPoly(src, 0, dst, 0, src.length/2);
        Bitmap bm = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);
        iv2.setImageBitmap(bm);
        showToast(matrix);
    }

    public static void actionStart(Context context){
        context.startActivity(new Intent(context,MatrixActivity_.class));
    }

}
