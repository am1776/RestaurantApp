package com.amallya.doordash.takehome.view.restaurantDetail;

import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.model.RestaurantDetail;

import java.util.List;

/**
 * Created by anmallya on 8/27/2017.
 */

public interface RestaurantDetailContract {

    interface View {
        void updateData(RestaurantDetail restaurantDetail);
    }

    interface Presenter {

        void loadData(int id);

        void onDestroy();
    }

}
