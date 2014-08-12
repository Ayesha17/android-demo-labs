package com.example.small;

import android.app.Activity;
import android.os.Bundle;
import com.example.small.vo.Person;
import com.example.small.vo.User;

/**
 * @author TechBirds
 * @date 14-8-12
 * @time 下午5:55
 * @vsersion 1.0
 */
public class Activity02 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        分解方式 -推荐
//        Person person = (Person)getIntent().getParcelableExtra("person_data");

//        序列化方式
//        User user = (User) getIntent().getSerializableExtra("user_data");


    }
}
