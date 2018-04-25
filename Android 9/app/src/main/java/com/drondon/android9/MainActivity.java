package com.drondon.android9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CoinDataSource dataSource = new CoinDataSource();
        dataSource.load(new CoinDataSource.ResultCallback() {
            @Override
            public void onResult(List<Coin> coins) {
                CoinRecyclerViewAdapter adapter = new CoinRecyclerViewAdapter(coins);
                recyclerView.setAdapter(adapter);
            }
        });
    }

}
