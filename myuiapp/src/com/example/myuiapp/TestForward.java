package com.example.myuiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by wang on 14-6-10.
 */
public class TestForward extends Activity{

    private static final int GET_CODE = 0;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forward);

        editText = (EditText)findViewById(R.id.editText);
        Button go = (Button)findViewById(R.id.button);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(TestForward.this,TestForwardTarget.class);

                //纯粹的启动跳转
                //startActivity(intent);

                startActivityForResult(intent,GET_CODE);

                //finish();

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_CODE){

            if(resultCode == RESULT_CANCELED){
                editText.append("cancelled");
            }else{
                editText.append("ok");
                if(data != null){
                    editText.append(data.getAction());
                }
            }
            editText.append("\n");
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
