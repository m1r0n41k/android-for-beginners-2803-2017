package com.drondon.android9.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.drondon.android9.MainActivity;
import com.drondon.android9.R;

public class SplashActivity extends AppCompatActivity {

    public static final String PREF_KEY_TUTORIAL_COMPLETE = "tutorial_complete";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        /*1*/  //sharedPreferences.getBoolean("tutorial_complete", false);
        /*2*/   //sharedPreferences.getBoolean(PREF_KEY_TUTORIAL_COMPLETE, false);
        /*3*/
        boolean complete = sharedPreferences.getBoolean(getString(R.string.pref_key_tutorial_complete), false);

        if (complete) {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        } else {
            startActivity(new Intent(getBaseContext(), TutorialActivity.class));
        }
        //Stop current activity
        finish();
    }


    public static class A {

    }
}
