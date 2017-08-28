package com.amallya.doordash.takehome.data.repository;


import com.amallya.doordash.takehome.model.Restaurant;
import java.util.List;
import rx.Observable;

/**
 * Created by anmallya on 8/26/2017.
 */

public interface RestaurantRepository {

    Observable<List<Restaurant>> getRestaurantList();

    Observable<List<Restaurant>> getRestaurantListNetwork();

    void insertRestaurantsToDb(List<Restaurant> list);

    void onRestaurantFavorited(Restaurant restaurant);
}

