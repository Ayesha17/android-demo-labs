package com.example.small;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button exitBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        exitBtn = (Button)findViewById(R.id.exit_btn);
        exitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.exit_btn:

                Intent intent01 = new Intent(this,Activity01.class);
                startActivity(intent01);

                break;

        }

    }
}
