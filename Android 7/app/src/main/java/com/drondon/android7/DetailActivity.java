package com.drondon.android7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends LogActivity implements View.OnClickListener {
    View buttonBack;
    View buttonToFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);

        buttonToFirst = findViewById(R.id.buttonToFirst);
        buttonToFirst.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.buttonBack:
                // finish();
                onBackPressed();
                break;

            case R.id.buttonToFirst:
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        buttonBack.setOnClickListener(null);
    }

}
