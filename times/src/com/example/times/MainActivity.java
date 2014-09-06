package com.example.times;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Calendar c= Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,1);

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DAY_OF_MONTH,31);

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();
//        calendar.init(today, nextYear.getTime())
//                .withSelectedDate(today);


        calendar.init(c.getTime(),c1.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE);

        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Log.d(TAG,date.toString());
            }

            @Override
            public void onDateUnselected(Date date) {
                Log.d(TAG,date.toString());
            }
        });


    }
}
