package com.drondon.android7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SecondActivity extends LogActivity {

    private Switch switchView;

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        switchView = findViewById(R.id.switch1);

        CompoundButton.OnCheckedChangeListener checkedListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                Toast toast = Toast.makeText(v.getContext(), "Switch checked : " + isChecked, Toast.LENGTH_SHORT);
                toast.show();
                //toast.cancel();
            }
        };

        switchView.setOnCheckedChangeListener(checkedListener);

        findViewById(R.id.imageButtonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DetailActivity.class));
            }
        });

        String title = this.getString(R.string.app_title_second_screen);
        String quantityString = this.getResources().getQuantityString(R.plurals.app_plurals, 0);

        int color = ContextCompat.getColor(this, R.color.colorAccent);

        Log.d(TAG, "onCreate: " + title);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        switchView.setOnCheckedChangeListener(null);
    }
}
