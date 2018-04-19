package com.drondon.lecture6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.drondon.lecture6.models.User;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";
    private int counter = 0;
    private View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() {
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Log.d(TAG, "onLayoutChange() called with: v = [" + v + "], left = [" + left + "], top = [" + top + "], right = [" + right + "], bottom = [" + bottom + "], oldLeft = [" + oldLeft + "], oldTop = [" + oldTop + "], oldRight = [" + oldRight + "], oldBottom = [" + oldBottom + "]");
        }
    };

    //Log.d(TAG, "onCreate: counter: " + counter);
    private View buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLogin = findViewById(R.id.buttonLogin);

        final EditText editTextEmail = findViewById(R.id.editTextEmail);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                //validate

                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_KEY_USER, new User(email, password));

                startActivityForResult(intent, SecondActivity.REQUEST_CODE);
            }
        };
        buttonLogin.setOnClickListener(clickListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SecondActivity.REQUEST_CODE) {
            Log.d(TAG, "onActivityResult: " + (resultCode == Activity.RESULT_OK));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("COUNTER");
        Log.d(TAG, "onRestoreInstanceState: counter: " + counter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        buttonLogin.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        buttonLogin.removeOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNTER", ++counter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
