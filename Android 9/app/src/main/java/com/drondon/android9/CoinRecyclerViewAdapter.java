package com.drondon.android9;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CoinRecyclerViewAdapter extends RecyclerView.Adapter<CoinRecyclerViewAdapter.CoinViewHolder> {

    private List<Coin> coinList;

    public CoinRecyclerViewAdapter(List<Coin> coinList) {
        this.coinList = coinList;
    }


    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_coin, parent, false);

        return new CoinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        Coin coin = coinList.get(position);
        holder.setData(coin);
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }


    public class CoinViewHolder extends RecyclerView.ViewHolder {

        private TextView rank, simbol, name, marketCap, priceUsd, percent24h;

        public CoinViewHolder(View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rankTextView);
            simbol = itemView.findViewById(R.id.simbolTextView);
            name = itemView.findViewById(R.id.nameTextView);
            marketCap = itemView.findViewById(R.id.marketCapTextView);
            priceUsd = itemView.findViewById(R.id.priceTextView);
            percent24h = itemView.findViewById(R.id.percentTextView);
        }

        public void setData(Coin coin) {
            rank.setText(String.valueOf(coin.getRank()));
            simbol.setText(String.valueOf(coin.getSimbol()));
            name.setText(String.valueOf(coin.getName()));
            marketCap.setText(String.valueOf(coin.getMarketCap()) + "$");
            priceUsd.setText(String.valueOf(coin.getPriceUsd()) + "$");
            percent24h.setText(String.valueOf(coin.getPercent24h()) + "%");
        }
    }
}
