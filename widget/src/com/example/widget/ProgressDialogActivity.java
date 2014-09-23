package com.example.widget;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

/**
 * Created by Techbirds on 14-8-28.
 */
public class ProgressDialogActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SomeTask().execute();
    }

    class SomeTask extends AsyncTask<Void, Void, Integer>
    {

        private ProgressDialog progressDialog ;


        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(ProgressDialogActivity.this);
            progressDialog.setMessage("Doing something...");
            progressDialog.show();
        }

        @Override
        protected Integer doInBackground(Void... params)
        {
            //Task for doing something
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 0;
        }

        @Override
        protected void onPostExecute(Integer result)
        {

            if(result==0)
            {
                //do some thing
            }
            // after completed finished the progressbar
            progressDialog.dismiss();
        }
    }

    public static void actionStart(Context context){
        Intent intent = new Intent(context,ProgressDialogActivity.class);
        context.startActivity(intent);
    }
}
