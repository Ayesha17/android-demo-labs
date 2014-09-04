package com.example.small;

import android.app.Activity;
import android.util.Log;
import android.view.View;

/**
 * Created by Techbirds on 14-8-30.
 */
public class BaseActivity extends Activity {

    private final static String TAG = "BaseActivity";

    @SuppressWarnings("unchecked")
    public final <E extends View> E getView (int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            Log.e(TAG, "Could not cast View to concrete class.", ex);
            throw ex;
        }
    }

}
