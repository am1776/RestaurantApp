package com.amallya.doordash.takehome.view.restaurantList;

import android.content.Context;
import android.util.Log;

import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.data.repository.impl.RestaurantRepositoryImpl;
import com.amallya.doordash.takehome.model.Restaurant;

import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantListPresenter implements RestaurantListContract.Presenter{

    private RestaurantRepository restaurantRepository;
    private List<Restaurant> restaurantList;
    private RestaurantListContract.View view;
    private CompositeSubscription compositeSubscription;

    public RestaurantListPresenter(RestaurantRepository restaurantRepository, RestaurantListContract.View view) {
        this.restaurantRepository = restaurantRepository; //new RestaurantRepositoryImpl(context);
        compositeSubscription = new CompositeSubscription();
        this.view = view;
    }

    @Override
    public void loadData() {
        if(restaurantList == null){
            loadDataHelper();
        } else{
            refreshUi();
        }
    }

    /*
    If the list is null, fetch data from the DB.
    If the DB does not contain data make a network call to fetch the data.
    */

    public void loadDataHelper() {
        if (view != null) {
            Log.i("F","Load Data called");
            Subscription subscription = restaurantRepository.getRestaurantList().subscribe(
                    restaurantLists -> {
                        restaurantList = restaurantLists;
                        if (isRestaurantListEmpty()) {
                            Subscription subscription1 = restaurantRepository.getRestaurantListNetwork().subscribe(restaurants -> {
                                Log.i("F","Data recieved");
                                restaurantList = restaurants;
                                refreshUi();
                                restaurantRepository.insertRestaurantsToDb(restaurantList);
                            });
                            compositeSubscription.add(subscription1);
                        }else{
                            refreshUi();
                        }
                    }, throwable -> {
                        throwable.printStackTrace();
                    });
            compositeSubscription.add(subscription);
        }
    }

    private boolean isRestaurantListEmpty(){
        return restaurantList.size() == 0;
    }


    @Override
    public void onRestaurantFavorited(Restaurant restaurant) {
        restaurantRepository.onRestaurantFavorited(restaurant);
    }

    @Override
    public void refreshUi() {
        if (view != null) {
            view.updateData(restaurantList);
        }
    }

    @Override
    public void onDestroy() {
        view = null;
        compositeSubscription.unsubscribe();
    }

}

