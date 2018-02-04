package com.amallya.doordash.takehome.data.service;

import com.amallya.doordash.takehome.utils.Url;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.amallya.doordash.takehome.utils.Url.BASE_URL;

/**
 * Created by anmallya on 8/27/2017.
 */

public class ServiceApi {
    private static ServiceApi instance = null;

    private RestaurantService restaurantService;

    public static ServiceApi getInstance() {
        if (instance == null) {
            instance = new ServiceApi();
        }
        return instance;
    }

    private ServiceApi() {
        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        this.restaurantService = retrofit.create(RestaurantService.class);
    }

    public RestaurantService getUserService() {
        return this.restaurantService;
    }

}
