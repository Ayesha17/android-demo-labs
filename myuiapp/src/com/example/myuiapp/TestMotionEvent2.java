package com.example.myuiapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wang on 14-6-10.
 */
public class TestMotionEvent2 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TestMotionView(this));
    }


    public class TestMotionView extends View{

        private Paint mPaint = new Paint();

        private int Action;
        private float x;
        private float y;

        public TestMotionView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            Action = event.getAction();
            x = event.getX();
            y = event.getY();

            // 重新绘制
            invalidate();

            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {

            Paint paint = mPaint;

            canvas.drawColor(Color.WHITE);

            if(MotionEvent.ACTION_MOVE == Action){
                paint.setColor(Color.RED);
            }else if(MotionEvent.ACTION_UP == Action){
                paint.setColor(Color.GREEN);
            }else if(MotionEvent.ACTION_DOWN == Action){
                paint.setColor(Color.BLUE);
            }

            canvas.drawCircle(x,y,10,paint);
            setTitle("A = " + Action + "[" + x + "," + y + "]");

//            super.onDraw(canvas);
        }
    }



}
