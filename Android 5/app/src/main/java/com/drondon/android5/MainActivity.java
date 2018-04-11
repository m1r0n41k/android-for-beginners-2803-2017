package com.drondon.android5;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setText("Hello");
        setContentView(button);

        final TextInputLayout layoutEmail = findViewById(R.id.emailLayout);
        TextInputEditText etEmail = findViewById(R.id.email);

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button mainButton = findViewById(R.id.login);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutEmail.setError("Empty email");
                Log.d(TAG, "onClick: " + R.layout.activity_main_2);
            }
        });

    }
}
