package com.drondon.android9;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FavoriteRecyclerViewAdapter
        extends ListAdapter<Coin, FavoriteRecyclerViewAdapter.FavoriteCoinViewHolder> {


    protected FavoriteRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<Coin> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public FavoriteCoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_coin_favorite, parent, false);
        return new FavoriteCoinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteCoinViewHolder holder, int position) {
        Coin coin = getItem(position);
        holder.setData(coin, position);
    }


    public static class FavoriteCoinViewHolder extends RecyclerView.ViewHolder {

        TextView symbol, rank;

        public FavoriteCoinViewHolder(View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.simbolTextView);
            rank = itemView.findViewById(R.id.rankTextView);
        }

        public void setData(Coin coin, int position) {
            symbol.setText(coin.getSymbol());
            rank.setText(String.valueOf(coin.getRank()));
        }
    }
}
