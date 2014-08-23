package com.example.photowallfallsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.act_main);
	}

    public void onBtnClick(View view) {

        switch (view.getId()){

            case R.id.test_btn:

                Intent intentTest = new Intent(this,ImageLoadTestActivity.class);
                startActivity(intentTest);

                break;

            case R.id.wall_btn:

                Intent intentWall = new Intent(this,PhotoWallFallsActivity.class);
                startActivity(intentWall);

                break;

            default:
                break;

        }

    }
}
