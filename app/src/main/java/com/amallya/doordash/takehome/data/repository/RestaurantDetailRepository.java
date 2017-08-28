package com.amallya.doordash.takehome.data.repository;

import com.amallya.doordash.takehome.data.service.RestaurantService;
import com.amallya.doordash.takehome.data.service.ServiceApi;
import com.amallya.doordash.takehome.model.RestaurantDetail;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.amallya.doordash.takehome.utils.Url.BASE_URL;

/**
 * Created by anmallya on 8/26/2017.
 */

public interface RestaurantDetailRepository {
    Observable<RestaurantDetail> getRestaurantDetail(int restaurantId);
}
