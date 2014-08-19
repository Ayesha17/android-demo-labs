package com.example.myapp;

import android.app.*;
import android.os.Bundle;
import android.text.InputType;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.*;

import java.util.ArrayList;
import java.util.Calendar;

public class MyActivity extends Activity implements View.OnClickListener{

    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;

    private LinearLayout linearLayout01;
    private LinearLayout linearLayout02;
    private LinearLayout linearLayout03;
    private LinearLayout linearLayout04;
    private LinearLayout linearLayout05;

    private ViewGroup rootViewGroup;

    private ArrayList<View> controls;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        rootViewGroup = ((ViewGroup)getWindow().getDecorView());

        initView();
    }

    public void initView(){

        btn01 = (Button) findViewById(R.id.text_view_btn);
        btn02 = (Button) findViewById(R.id.button_btn);
        btn03 = (Button) findViewById(R.id.exit_text_btn);
        btn04 = (Button) findViewById(R.id.ck_rd_btn);
        btn05 = (Button) findViewById(R.id.spinner_btn);
        btn06 = (Button) findViewById(R.id.time_picker_btn);
        btn07 = (Button) findViewById(R.id.date_picker_btn);

        linearLayout01 = (LinearLayout) findViewById(R.id.text_view);
        linearLayout02 = (LinearLayout) findViewById(R.id.button);
        linearLayout03 = (LinearLayout) findViewById(R.id.edit_text);
        linearLayout04 = (LinearLayout) findViewById(R.id.ck_rd);
        linearLayout05 = (LinearLayout) findViewById(R.id.spinner);

        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn05.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);

        initView03();
        initView05();


    }

    public void initView03(){

        EditText editText = (EditText)linearLayout03.findViewById(R.id.password);

        AutoCompleteTextView editText1 = (AutoCompleteTextView)linearLayout03.findViewById(R.id.country_name);

        // 监听键盘的回车事件
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                boolean handle = false;

                if(actionId == EditorInfo.IME_ACTION_SEARCH){

                    Log.d("onEditorAction","search");
                    Toast.makeText(MyActivity.this,"search ...",Toast.LENGTH_SHORT).show();
                    handle = true;
                }

                return handle;
            }
        });


        String[] countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        editText1.setAdapter(arrayAdapter);
    }

    public void initView05(){

        Spinner spinner = (Spinner)linearLayout05.findViewById(R.id.test_spinner);

        String[] countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countries);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //可以使用方法parent.getItemAtPosition(pos)获得用户选择的选项
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.text_view_btn :

                controls = getViewsByTag(rootViewGroup,"control");
                for(View view1 : controls){
                    view1.setVisibility(View.GONE);
                }

                linearLayout01.setVisibility(View.VISIBLE);

                break;
            case R.id.button_btn :

                controls = getViewsByTag(rootViewGroup,"control");
                for(View view1 : controls){
                    view1.setVisibility(View.GONE);
                }

                linearLayout02.setVisibility(View.VISIBLE);

                break;
            case R.id.exit_text_btn:

                controls = getViewsByTag(rootViewGroup,"control");
                for(View view1 : controls){
                    view1.setVisibility(View.GONE);
                }

                linearLayout03.setVisibility(View.VISIBLE);

                break;

            case R.id.ck_rd_btn:

                controls = getViewsByTag(rootViewGroup,"control");
                for(View view1 : controls){
                    view1.setVisibility(View.GONE);
                }

                linearLayout04.setVisibility(View.VISIBLE);

                break;

            case R.id.spinner_btn:

                controls = getViewsByTag(rootViewGroup,"control");
                for(View view1 : controls){
                    view1.setVisibility(View.GONE);
                }

                linearLayout05.setVisibility(View.VISIBLE);

                break;

            case R.id.time_picker_btn:

                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(), "timePicker");

                break;

            case R.id.date_picker_btn:

                DialogFragment newFragment1 = new DatePickerFragment();
                newFragment1.show(getFragmentManager(), "datePicker");

                break;

        }

    }

    public void onCheckedClick(View view){

        boolean isChecked = ((CheckBox)view).isChecked();

        switch (view.getId()){

            case R.id.timing_push_check_box:

                if(isChecked){

                }else{

                }


                break;
            case R.id.timing_shut_check_box:

                if(isChecked){

                }else{

                }

                break;

        }

    }


    public void onToggleClicked (View view) {
        // 判断是否处在“on”状态下
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            // on 状态下的逻辑
        } else {
            // off 状态下的逻辑
        }
    }

    public void onRadioButtonClicked(View view){

    }

    // 根据指定tag获取View
    private static ArrayList<View> getViewsByTag(ViewGroup root, String tag){

        ArrayList<View> views = new ArrayList<View>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if (tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }

        }
        return views;
    }


    class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //用当前时间作为picker的默认时间
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            // 创建TimePickerDialog对象并返回该对象
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            //当用户设置好（点击“Set”按钮）之后的逻辑
        }
    }

    class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //使用当前日期作为date picker 的默认显示日期
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // 创建 DatePickerDialog 对象并返回给对象
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int month, int day) {
            //当用户设置好（点击“Set”按钮）之后的逻辑
        }
    }

}
