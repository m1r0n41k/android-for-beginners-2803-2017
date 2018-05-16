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

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new FirstFragment())
                    .commit();
        }

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.one:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, FirstFragment.newInstance("ONE"))
                                .addToBackStack(null)
                                .commit();
                        return true;

                    case R.id.two:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new SecondFragment())
                                .addToBackStack(null)
                                .commit();
                        return true;

                    case R.id.three:
                        Toast.makeText(MainActivity.this, "Three", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

    }
}
