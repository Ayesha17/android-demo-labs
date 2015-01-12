package com.example.json;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.json.vo.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        test1();
    }

    private void test1(){
        Person p1 = new Person();
        p1.setId(1);
        p1.setAge(26);
        p1.setName("TechBirds");
        p1.setCreatedDate(new Date());

        // 单个对象

        // 序列化
        JSON.toJSONString(p1);

        // 反序列化
        Person p11 = JSON.parseObject(JSON.toJSONString(p1),Person.class);

        // 多个对象

        List<Person> personList1 = new ArrayList<Person>();
        personList1.add(new Person(1,"TechBirds1",23,new Date()));
        personList1.add(new Person(2,null,24,new Date()));
        personList1.add(new Person(3,"TechBirds1",25,new Date()));

        JSON.toJSONString(personList1);
        List<Person> personList11 = JSON.parseObject(JSON.toJSONString(personList1),new TypeReference<List<Person>>(){});
    }

}
