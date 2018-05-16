package com.drondon.android15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean progress = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequiredEditText editText = findViewById(R.id.editText);
        final ProgressButton button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress) {
                    button.hideProgress();
                } else {
                    button.showProgress();
                }
                progress = !progress;
                Toast.makeText(v.getContext(), "Valid = " + editText.validate(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
