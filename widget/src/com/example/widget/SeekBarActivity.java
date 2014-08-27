package com.example.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by Techbirds on 14-8-27.
 */
public class SeekBarActivity extends Activity{

    private TextView seekBarTv;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_seekbar);

        seekBarTv = (TextView)findViewById(R.id.seekbar_tv);
        seekBar = (SeekBar) findViewById(R.id.seekbar);

        //seekBarTv.setText("Covered: " + seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                this.progress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarTv.setText(Arrays.toString(splitToComponentTimes(seekBar.getProgress())));

            }
        });

    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,SeekBarActivity.class);
        context.startActivity(intent);
    }

    public static int[] splitToComponentTimes(int seconds)
    {
        long longVal = seconds;
        int hours = (int) longVal / 3600;
        int remainder = (int) longVal - hours * 3600;
        int mins = remainder / 60;
        remainder = remainder - mins * 60;
        int secs = remainder;
        int[] ints = {hours , mins , secs};
        return ints;
    }
}
