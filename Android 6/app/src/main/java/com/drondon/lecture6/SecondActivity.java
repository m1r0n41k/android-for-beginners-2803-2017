package com.drondon.lecture6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.drondon.lecture6.models.User;

public class SecondActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 170;

    public static final String EXTRA_KEY_USER = "user";
    @Nullable
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent.hasExtra(EXTRA_KEY_USER)) {
                user = (User) intent.getSerializableExtra(EXTRA_KEY_USER);
            }
        }

        TextView textView = findViewById(R.id.textView2);
        if (user != null) {
            textView.setText(String.format("Email : %s , password : %s", user.getEmail(), user.getPassword()));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        boolean validEmail = user != null && user.getEmail().contains("@");
        setResult(validEmail ? Activity.RESULT_OK : Activity.RESULT_CANCELED);
        finish();
    }
}
