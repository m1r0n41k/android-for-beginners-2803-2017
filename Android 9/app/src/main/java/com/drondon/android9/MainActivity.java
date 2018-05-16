package com.drondon.android9;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.drondon.android9.setting.SettingsActivity;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        long firstLaunch = sharedPreferences.getLong(getString(R.string.pref_key_first_launch_time), System.currentTimeMillis());
        int launchNumber = sharedPreferences.getInt(getString(R.string.pref_key_launch_number), 0);

        if (launchNumber > 5
                && System.currentTimeMillis() - firstLaunch > TimeUnit.MINUTES.toMillis(2)) {
            showRateUsDialog();
        }

        //Только при первом запуске приложения
        if (savedInstanceState == null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(getString(R.string.pref_key_launch_number), ++launchNumber);
            editor.apply();
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CoinDataSource dataSource = new CoinDataSource();
        dataSource.load(new CoinDataSource.ResultCallback() {
            @Override
            public void onResult(List<Coin> coins) {
                final CoinRecyclerViewAdapter adapter = new CoinRecyclerViewAdapter(coins, dataSource.getFavorites());

                adapter.setOnFavoriteChangeListener(new CoinRecyclerViewAdapter.OnFavoriteChangeListener() {
                    @Override
                    public void onChange(View view, Coin coin) {
                        //write to data base
                        if (coin.isFavorite()) {
                            dataSource.getFavorites().add(coin);
                        } else {
                            dataSource.getFavorites().remove(coin);
                        }
                        adapter.updateFavorites();
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });

        RecyclerClickListener listener = new RecyclerClickListener(this, recyclerView, new RecyclerClickListener.OnTouchActionListener() {
            @Override
            public void onClick(View view, int position) {
                RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(view);
                if (holder instanceof CoinRecyclerViewAdapter.CoinViewHolder) {
                    CoinRecyclerViewAdapter.CoinViewHolder coinViewHolder = (CoinRecyclerViewAdapter.CoinViewHolder) holder;
                    Coin coin = coinViewHolder.getCoin();
                    openDetail(String.format("https://coinmarketcap.com/currencies/%s/", coin.getId()));
                }
            }
        });

        //Added listener to
        recyclerView.addOnItemTouchListener(listener);

        App.get().getSessionData();
    }

    private void openDetail(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Favorite enabled: " + sharedPreferences.getBoolean(getString(R.string.pref_key_show_favorite), true), Toast.LENGTH_SHORT).show();
        //TODO Update adapter
    }


    private void showRateUsDialog() {
        boolean ratedUs = sharedPreferences
                .getBoolean(getString(R.string.pref_key_rated_us), false);
        if (!ratedUs) {
            new AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog_Alert)
                    .setMessage("Проголосуешь за нашу апку?")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean(getString(R.string.pref_key_rated_us), true);
                            editor.apply();
                            //start Play Store app with your package
                        }
                    }).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(getBaseContext(), SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
