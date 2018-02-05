package com.amallya.doordash.takehome.view.restaurantList;

import com.amallya.doordash.takehome.model.Restaurant;

import java.util.List;

/**
 * Created by anmallya on 8/27/2017.
 */

public interface RestaurantListContract {

    interface View {
        void updateData(List<Restaurant> restaurantListList);
    }

    interface Presenter {

        void loadData();

        void refreshUi();

        void onDestroy();

        void onRestaurantFavorited(Restaurant restaurant);
    }

}