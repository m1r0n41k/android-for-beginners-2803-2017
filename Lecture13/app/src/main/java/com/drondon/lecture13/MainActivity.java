package com.drondon.lecture13;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";
    private TextView textView;
    private TextView textView2;
    private MyAsyncTask myAsyncTask;

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
                myAsyncTask.cancel(false);
            }
        });

        printThreadInfo();

        myAsyncTask = new MyAsyncTask(textView);
        myAsyncTask.execute(1000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        myAsyncTask.cancel(true);
    }

    private static void printThreadInfo() {
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
            final int finalI = i;
            textView.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText("fromOneToHundred: " + finalI);
                }
            });
        }
    }

    public void fromHundredToOne() {
        for (int i = 1000; i >= 0; i--) {
            final int finalI = i;
            textView2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textView2.setText("fromOneToHundred: " + finalI);
                }
            }, 5000);
        }
    }

    public static class MyAsyncTask extends AsyncTask<Integer, Integer, String> {

        private TextView textView;

        public MyAsyncTask(TextView textView) {
            this.textView = textView;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Counter 1: " + -1);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            printThreadInfo();
            for (int i = 1000; i >= 0; i--) {
                if (!isCancelled()) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(i);
                } else {
                    return "Canceled!";
                }

            }
            return "Complete!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText("Counter 1: " + values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(textView.getContext(), "Result: " + s, Toast.LENGTH_SHORT).show();
        }
    }
}
