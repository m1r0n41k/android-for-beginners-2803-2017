package com.drondon.lecture13;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

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
        myAsyncTask.execute("https://api.coinmarketcap.com/v2/ticker/?limit=10");
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

    public static class MyAsyncTask extends AsyncTask<String, Integer, String> {

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
        protected String doInBackground(String... urls) {
            printThreadInfo();
            try {
                JSONObject
                return new HttpClient().request(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText("Counter 1: " + values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s == null) {
                Toast.makeText(textView.getContext(), "Error!", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText(s);
            }
        }
    }
}
