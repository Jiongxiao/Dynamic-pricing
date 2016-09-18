package com.example.kevin.second_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import java.text.ParseException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class first_activity extends AppCompatActivity {


    private EditText investment_amount;
    private EditText rate;
    private EditText year;
    private EditText sum;
    private TextView expect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);
        investment_amount=(EditText)findViewById(R.id.et1);
        sum=(EditText)findViewById(R.id.et2);
        rate=(EditText)findViewById(R.id.et3);
        year=(EditText)findViewById(R.id.et4);
//        expect=(TextView)findViewById(R.id.tv1);
    }

    public void second(View view){
        Intent intent1 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("SUM",sum.getText().toString());
        bundle.putString("RATE",rate.getText().toString());
        intent1.putExtras(bundle);
        //intent1.setClass(this,second_activity.class);
        intent1.setClass(this,multi_thread.class);
//        intent1.setClass(this,third_page.class);
        startActivity(intent1);

    }
    public void count(View view) throws ParseException{

        String str= rate.toString();
        NumberFormat nf=NumberFormat.getPercentInstance();//
        Number m=nf.parse(str);
        String a = m.toString();
        float n = Float.parseFloat(a);
        float count=Float.parseFloat(investment_amount.toString());
        int year_number = Integer.parseInt(year.toString());
        for(int b=0;b<year_number;b++){
            count=count*(1+n);
        }
        String count1=""+count;
//        expect.setText(count1);


    }


}
