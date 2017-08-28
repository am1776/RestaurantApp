package com.amallya.doordash.takehome.data.repository.impl;

import com.amallya.doordash.takehome.data.repository.RestaurantDetailRepository;
import com.amallya.doordash.takehome.data.service.RestaurantService;
import com.amallya.doordash.takehome.data.service.ServiceApi;
import com.amallya.doordash.takehome.model.RestaurantDetail;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantDetailRepositoryImpl implements RestaurantDetailRepository{

    public RestaurantDetailRepositoryImpl() {
    }

    @Override
    public Observable<RestaurantDetail> getRestaurantDetail(int restaurantId) {
        RestaurantService apiService = ServiceApi.getInstance().getUserService();
        Observable<RestaurantDetail> restaurantList = apiService.getRestaurantDetail(restaurantId);
        return restaurantList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
