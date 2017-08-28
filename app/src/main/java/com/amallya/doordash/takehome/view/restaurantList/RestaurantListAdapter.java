package com.amallya.doordash.takehome.view.restaurantList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.amallya.doordash.takehome.R;
import com.amallya.doordash.takehome.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {

    private List<Restaurant> restaurantList;
    private Context context;
    private RestaurantClickListener restaurantClickListener;

    RestaurantListAdapter(List<Restaurant> restaurantList, Context context, RestaurantClickListener restaurantClickListener){
        this.restaurantList = restaurantList;
        this.context = context;
        this.restaurantClickListener = restaurantClickListener;
    }

    public void replaceDataSet(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
        notifyDataSetChanged();
    }

    public Restaurant getItem(int position) {
        return restaurantList.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Restaurant restaurant = restaurantList.get(position);
        holder.restauranStatusTv.setText(restaurant.getStatus());
        holder.restaurantNameTv.setText(restaurant.getName());
        holder.restaurantTypeTv.setText(restaurant.getDescription());

        setFavoriteButton( restaurant, holder);

        holder.favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                restaurant.setIsFavorited(!restaurant.getIsFavorited());
                setFavoriteButton( restaurant, holder);
                restaurantClickListener.onRestaurantFavorited(restaurant);
            }
        });

        Picasso.with(context).load(restaurant.getCoverImgUrl()).into(holder.restaurantCoverIv);
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurantClickListener.onRestaurantClick(restaurant);
            }
        });
    }

    private void setFavoriteButton(Restaurant restaurant, RestaurantListAdapter.ViewHolder holder){
        if(restaurant.getIsFavorited()){
            holder.favoriteButton.setImageResource(R.drawable.ic_star_black_24dp);
        } else{
            holder.favoriteButton.setImageResource(R.drawable.ic_star_grey_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


    public interface RestaurantClickListener {
        void onRestaurantClick(Restaurant restaurant);
        void onRestaurantFavorited(Restaurant restaurant);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.restaurantNameTv)
        TextView restaurantNameTv;

        @BindView(R.id.restaurantTypeTv)
        TextView restaurantTypeTv;

        @BindView(R.id.restaurantStatusTv)
        TextView restauranStatusTv;

        @BindView(R.id.restaurantIv)
        ImageView restaurantCoverIv;

        @BindView(R.id.favorite_button)
        ImageButton favoriteButton;

        @BindView(R.id.parentView)
        View parentView;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
