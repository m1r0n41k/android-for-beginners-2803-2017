package com.drondon.android15;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        ColorStateList colorStateList = ContextCompat.getColorStateList(this, R.color.app_navigation_colors);
        bottomNavigation.setItemIconTintList(colorStateList);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.one:
                        Toast.makeText(MainActivity.this, "One", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.two:
                        Toast.makeText(MainActivity.this, "Two", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.three:
                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });

    }
}
