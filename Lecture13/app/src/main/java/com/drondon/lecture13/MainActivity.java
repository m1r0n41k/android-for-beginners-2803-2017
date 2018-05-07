package com.drondon.lecture13;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";
    private TextView textView;
    private TextView textView2;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            printThreadInfo();
            int viewId = msg.arg1;
            switch (viewId) {
                case R.id.textView:
                    textView.setText((String) msg.obj);
                    break;

                case R.id.textView2:
                    textView2.setText((String) msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });

        printThreadInfo();
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                printThreadInfo();
                fromOneToHundred();
            }
        };

        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                printThreadInfo();
                fromHundredToOne();
            }
        };

        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        boolean isCurrentThread = Thread.currentThread().getName() == "main";


    }

    private void printThreadInfo() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        Log.d(TAG, "threadName: " + threadName);
    }

    public void fromOneToHundred() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = new Message();
            message.arg1 = R.id.textView;
            message.obj = "fromOneToHundred: " + i;
            handler.sendMessage(message);
        }
    }

    public void fromHundredToOne() {
        for (int i = 1000; i >= 0; i--) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = new Message();
            message.arg1 = R.id.textView2;
            message.obj = "fromHundredToOne: " + i;
            handler.sendMessage(message);
        }
    }
}
