package com.drondon.android7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.view.View.*;

public class MainActivity extends LogActivity {

    private static final String TAG = "MainActivity_";
    private long lastClickTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.buttonNext);

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(v.getContext(), SecondActivity.class));
            }
        };

        view.setOnClickListener(clickListener);

        // the same

        //View.OnClickListener clickListener = new Acivity$OnClickListener(this)
        //view.setOnClickListener(clickListener);

        // the same

        //view.setOnClickListener(new Acivity$OnClickListener(this));
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Log.d(TAG, "onBackPressed: ");
        if(System.currentTimeMillis() - lastClickTime < 200){
            super.onBackPressed();
        }
        lastClickTime = System.currentTimeMillis();
    }

    public static class Acivity$OnClickListener implements OnClickListener {

        private MainActivity $mainActivity;

        public Acivity$OnClickListener(MainActivity mainActivity) {
            this.$mainActivity = mainActivity;
        }

        @Override
        public void onClick(View v) {
            $mainActivity.startActivity(new Intent(v.getContext(), SecondActivity.class));
        }
    }

}
