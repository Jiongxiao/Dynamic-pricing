package com.example.kevin.second_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class third_page extends AppCompatActivity {
    private Bundle bundle2;
    private TextView original_pay;
    private TextView new_pay;
    private TextView Saved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        DecimalFormat df   = new DecimalFormat("######0.000");
       bundle2=this.getIntent().getExtras();
        String sum=bundle2.getString("SUM");
        String rate=bundle2.getString("RATE");
        String remain=bundle2.getString("REMAINVALUE");
        Double sum1=Double.parseDouble(sum);
        Double rate1=Double.parseDouble(rate);
        Double saved=sum1*(1+rate1)-Double.parseDouble(remain);
//
        original_pay = (TextView)findViewById(R.id.originalPay);
        new_pay = (TextView)findViewById(R.id.newPay);
        Saved=(TextView)findViewById(R.id.tv_saved);
       original_pay.setText(String.valueOf(sum1*(1+rate1)));
        new_pay.setText(remain);
        Saved.setText(String.valueOf(df.format(saved)));

    }
}
