package com.drondon.android9.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.drondon.android9.MainActivity;
import com.drondon.android9.R;
import com.squareup.picasso.Picasso;

public class TutorialActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(getString(R.string.pref_key_tutorial_complete), true);
                editor.putLong(getString(R.string.pref_key_first_launch_time), System.currentTimeMillis());
                editor.apply();

                startActivity(new Intent(v.getContext(), MainActivity.class));

                //Stop current activity
                finish();
            }
        });

        ImageView view = findViewById(R.id.imageView);

        Picasso.get().load("https://sputnik.kg/images/101808/13/1018081344.jpg").into(view);

    }


}
