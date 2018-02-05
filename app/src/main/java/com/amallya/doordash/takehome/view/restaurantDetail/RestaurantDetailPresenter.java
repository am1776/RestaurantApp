package com.amallya.doordash.takehome.view.restaurantDetail;

import com.amallya.doordash.takehome.data.repository.RestaurantDetailRepository;
import com.amallya.doordash.takehome.data.repository.impl.RestaurantDetailRepositoryImpl;
import com.amallya.doordash.takehome.model.RestaurantDetail;

import rx.Subscription;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantDetailPresenter implements RestaurantDetailContract.Presenter{

    private RestaurantDetailRepository restaurantDetailRepository;
    private RestaurantDetail restaurantDetail;
    RestaurantDetailContract.View view;
    Subscription subscription;

    public RestaurantDetailPresenter(RestaurantDetailRepository restaurantDetailRepository, RestaurantDetailContract.View view) {
        this.restaurantDetailRepository = restaurantDetailRepository;
        this.view = view;
    }

    @Override
    public void loadData(int restaurantId) {
        if (view != null) {
            subscription = restaurantDetailRepository.getRestaurantDetail(restaurantId).subscribe(
                    restaurantDetails -> {
                        restaurantDetail = restaurantDetails;
                        refreshUi();
                    }, throwable -> {
                        throwable.printStackTrace();
                    });
        }
    }

    private void refreshUi() {
        if (view != null) {
            view.updateData(restaurantDetail);
        }
    }

    @Override
    public void onDestroy() {
        view = null;
        if(subscription != null){
            subscription.unsubscribe();
        }
    }

}
