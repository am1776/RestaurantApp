package com.amallya.doordash.takehome.data.service;

import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.model.RestaurantDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by anmallya on 8/26/2017.
 */

public interface RestaurantService {

    @GET("/v2/restaurant/")
    Observable<List<Restaurant>> getRestaurantList(@Query("lat") double lat, @Query("lng") double lng);


    @GET("/v2/restaurant/{restaurant_id}/")
    Observable<RestaurantDetail> getRestaurantDetail(@Path("restaurant_id") int restaurantId);
}
