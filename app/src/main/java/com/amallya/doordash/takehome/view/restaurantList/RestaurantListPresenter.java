package com.amallya.doordash.takehome.view.restaurantList;

import android.content.Context;
import android.util.Log;

import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.data.repository.impl.RestaurantRepositoryImpl;
import com.amallya.doordash.takehome.model.Restaurant;

import java.util.List;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantListPresenter implements RestaurantListContract.Presenter{

    private RestaurantRepository restaurantRepository;
    private List<Restaurant> restaurantList;
    RestaurantListContract.View view;

    public RestaurantListPresenter(Context context) {
        this.restaurantRepository = new RestaurantRepositoryImpl(context);
    }

    @Override
    public void setView(RestaurantListContract.View view) {
        this.view = view;
        if(restaurantList == null){
            loadData();
        } else{
            refreshUi();
        }
    }

    /*
    If the list is null, fetch data from the DB.
    If the DB does not contain data make a network call to fetch the data.
    */

    @Override
    public void loadData() {
        if (view != null) {
            Log.i("F","Load Data called");
            restaurantRepository.getRestaurantList().subscribe(
                    restaurantLists -> {
                        restaurantList = restaurantLists;
                        if (isRestaurantListEmpty()) {
                            restaurantRepository.getRestaurantListNetwork().subscribe(restaurants -> {
                                Log.i("F","Data recieved");
                                restaurantList = restaurants;
                                refreshUi();
                                restaurantRepository.insertRestaurantsToDb(restaurantList);
                            });
                        }else{
                            refreshUi();
                        }
                    }, throwable -> {
                        throwable.printStackTrace();
                    });
        }
    }

    private boolean isRestaurantListEmpty(){
        return restaurantList.size() == 0;
    }

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
    }

}

