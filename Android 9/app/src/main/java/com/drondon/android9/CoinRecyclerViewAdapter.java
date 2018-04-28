package com.drondon.android9;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CoinRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Coin> coinList;
    private List<Coin> coinListFavorite;

    public CoinRecyclerViewAdapter(List<Coin> coinList, List<Coin> coinListFavorite) {
        this.coinList = coinList;
        this.coinListFavorite = coinListFavorite;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(viewType, parent, false);

        if (viewType == R.layout.item_coin_favorite_list) {
            return new FavoriteCoinsViewHolder(itemView);
        } else {
            return new CoinViewHolder(itemView);
        }
    }

    private FavoriteCoinsViewHolder holder;

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FavoriteCoinsViewHolder) {
            this.holder = (FavoriteCoinsViewHolder) holder;
            updateFavorites();
        } else {
            int realPosition = position - 1;
            Coin coin = coinList.get(realPosition);
            ((CoinViewHolder) holder).setData(coin, realPosition);
        }
    }

    @Override
    public int getItemCount() {
        return coinList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? R.layout.item_coin_favorite_list : R.layout.item_coin;

    }

    @Override
    public long getItemId(int position) {
        return position == 0 ? 0 : coinList.get(position).getRank();
    }

    private static final String TAG = "CoinRecyclerViewAdapter";

    private CompoundButton.OnCheckedChangeListener checkedChangeListener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Log.d(TAG, "onCheckedChanged: " + isChecked + " button : " + buttonView);
            int id = buttonView.getId();

            switch (id) {
                case R.id.checkBox:
                    Coin coin = (Coin) buttonView.getTag(R.id.tag_coin_item);
                    coin.setFavorite(isChecked);
                    if (onFavoriteChangeListener != null) {
                        onFavoriteChangeListener.onChange(buttonView, coin);
                    }
                    break;
            }
        }
    };

    private OnFavoriteChangeListener onFavoriteChangeListener;

    public void setOnFavoriteChangeListener(OnFavoriteChangeListener onFavoriteChangeListener) {
        this.onFavoriteChangeListener = onFavoriteChangeListener;
    }

    public void updateFavorites() {
        holder.setData(coinListFavorite);
    }

    interface OnFavoriteChangeListener {
        void onChange(View view, Coin coin);
    }

    public class CoinViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox favorite;
        private TextView rank, simbol, name, marketCap, priceUsd, percent24h;

        public CoinViewHolder(View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.rankTextView);
            simbol = itemView.findViewById(R.id.simbolTextView);
            name = itemView.findViewById(R.id.nameTextView);
            marketCap = itemView.findViewById(R.id.marketCapTextView);
            priceUsd = itemView.findViewById(R.id.priceTextView);
            percent24h = itemView.findViewById(R.id.percentTextView);
            favorite = itemView.findViewById(R.id.checkBox);
        }

        public void setData(Coin coin, int position) {
            rank.setText(String.valueOf(coin.getRank()));
            simbol.setText(String.valueOf(coin.getSimbol()));
            name.setText(String.valueOf(coin.getName()));
            marketCap.setText(String.valueOf(coin.getMarketCap()) + "$");
            priceUsd.setText(String.valueOf(coin.getPriceUsd()) + "$");
            percent24h.setText(String.valueOf(coin.getPercent24h()) + "%");

            favorite.setOnCheckedChangeListener(null);
            favorite.setChecked(coin.isFavorite());
            favorite.setTag(R.id.tag_coin_item, coin);
            favorite.setTag(R.id.tag_coin_item_position, position);
            favorite.setOnCheckedChangeListener(checkedChangeListener);

        }
    }

    public class FavoriteCoinsViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;

        public FavoriteCoinsViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerViewHorizontal);
        }

        public void setData(List<Coin> data) {
            FavoriteRecyclerViewAdapter adapter = (FavoriteRecyclerViewAdapter) recyclerView.getAdapter();
            if (adapter == null) {
                adapter = new FavoriteRecyclerViewAdapter(new DiffUtil.ItemCallback<Coin>() {
                    @Override
                    public boolean areItemsTheSame(Coin oldItem, Coin newItem) {
                        return oldItem.getRank() == newItem.getRank();
                    }

                    @Override
                    public boolean areContentsTheSame(Coin oldItem, Coin newItem) {
                        return oldItem.isFavorite() == newItem.isFavorite();
                    }
                });
                recyclerView.setAdapter(adapter);
            }
            adapter.submitList(new ArrayList<>(data));
        }
    }
}
