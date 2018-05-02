package com.drondon.android9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CoinDataSource dataSource = new CoinDataSource(getApplicationContext());
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
    }

}
