package com.example.kevin.second_app;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class multi_thread extends AppCompatActivity {
    private Button btnEnd;
    private TextView labelTimer;
    private Thread clockThread;
    private boolean isRunning = true;
    private Handler handler;
    private Bundle bundle1;
    private TextView et1;
    private TextView et2;
    private TextView et3;
    private TextView et4;
    private TextView et5;
    private int i=0;
    public  int minute=10;

    private double remainvalue=0;

    DecimalFormat df   = new DecimalFormat("######0.00");
    DecimalFormat df1   = new DecimalFormat("######0.0");
    DecimalFormat dfRate   = new DecimalFormat("######0.0000");
    Run test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);
        bundle1=this.getIntent().getExtras();
        String sum=bundle1.getString("SUM");
        String rate=bundle1.getString("RATE");

        Double sum1=Double.parseDouble(sum);
        Double rate1=Double.parseDouble(rate);
        test=new Run(sum1,rate1);
        et1=(TextView) findViewById(R.id.et1) ;
        et2=(TextView)findViewById(R.id.et2) ;
        et3=(TextView)findViewById(R.id.et3) ;
        et4=(TextView)findViewById(R.id.et4) ;
        et5=(TextView)findViewById(R.id.et5) ;
//        btnEnd = (Button) findViewById(R.id.btnEnd);
//        btnEnd.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                isRunning = false;
//            }
//        });

        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        minute++;
                        test.buyer();
                        Date now = new Date();
                        SimpleDateFormat dateFormat=new SimpleDateFormat("HH");
                        String time1=dateFormat.format(now);
                        et1.setText(String.valueOf(df.format((test.paid/test.total)*100)+"%"));
                       Double Prate=test.rate*100;
                        et2.setText(String.valueOf((dfRate.format(Prate)))+"%");
                        et3.setText(String.valueOf(time1)+":"+String.valueOf(minute));
                        et4.setText(String.valueOf(df1.format(test.sum)));
                        et5.setText(String.valueOf(test.remain));

                        if(test.remain - 0 < 0.01){
                            et4.setText("0.0");
                            remainvalue = test.returnValue;
//                            jumptoThird();
                        }


                        if(test.remain<=0)break;

                }
            }

        };


        /* 线程体是Clock对象本身，线程名字为"Clock" */
        clockThread = new Thread(new Runnable() {
            @Override

            public void run() {
                int timer = 0;
                while (isRunning) {
                    try {
                        Thread.currentThread().sleep(1000);
                        timer++;
                        /* labelTimer.setText("逝去了 " + timer + " 秒"); */
                        Message msg = new Message();
                        msg.obj = timer;
                        msg.what = 0;
                        handler.sendMessage(msg);
//                        Log.d(TAG, "lost  time " + timer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        clockThread.start(); /* 启动线程 */
    }

    public void jumptoThird(View view){
        Intent intent2 = new Intent();
//        bundle1.putString("REMAINVALUE",String.valueOf("12"));
        bundle1.putString("REMAINVALUE",String.valueOf(df.format(remainvalue)));
        intent2.putExtras(bundle1);
        intent2.setClass(this,third_page.class);
        startActivity(intent2);
    }

}
