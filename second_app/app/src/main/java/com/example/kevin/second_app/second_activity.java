package com.example.kevin.second_app;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class second_activity extends AppCompatActivity {
    private Bundle bundle1;
    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        bundle1=this.getIntent().getExtras();
        String sum=bundle1.getString("SUM");
        et1=(EditText)findViewById(R.id.et1) ;
        et2=(EditText)findViewById(R.id.et2) ;
        et3=(EditText)findViewById(R.id.et3) ;
        et4=(EditText)findViewById(R.id.et4) ;
        et5=(EditText)findViewById(R.id.et5) ;
        for(int i=0;i<30;++i){
            try {
                et1.setText(i+"");
                et2.setText(i+"");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
