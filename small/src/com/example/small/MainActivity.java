package com.example.small;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.small.util.ViewFinder;
import com.example.small.vo.Person;
import com.example.small.vo.User;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button exitBtn;
    private Button intentObjTransferBtn;
    private Button dynamicAddView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ViewFinder viewFinder = new ViewFinder(this);
        viewFinder.find(R.id.exit_btn);

        exitBtn = getView(R.id.exit_btn);
        intentObjTransferBtn = getView(R.id.intent_obj_transfer_btn);

        exitBtn.setOnClickListener(this);
        intentObjTransferBtn.setOnClickListener(this);

        dynamicAddView = getView(R.id.dynamic_add_view);
        dynamicAddView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.exit_btn:

                Intent intent01 = new Intent(this,Activity01.class);
                startActivity(intent01);

                break;

            case R.id.intent_obj_transfer_btn:

                Intent intent02 = new Intent(this,Activity02.class);

//                1.
//                User user = new User();
//                user.uid = 1;
//                user.name = "TechBirds";
//                intent02.putExtra("user_data",user);

//                2.
//                Person person = new Person();
//                person.uid = 1;
//                person.name = "TechBirds";
//
//                intent02.putExtra("person_data",person);

                break;
            case R.id.dynamic_add_view:

                Intent intent03 = new Intent(this,Activity03.class);
                startActivity(intent03);
                break;


        }

    }
}
