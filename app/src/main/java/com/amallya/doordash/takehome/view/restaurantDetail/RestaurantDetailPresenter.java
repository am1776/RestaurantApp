package com.amallya.doordash.takehome.view.restaurantDetail;

import com.amallya.doordash.takehome.data.repository.RestaurantDetailRepository;
import com.amallya.doordash.takehome.data.repository.impl.RestaurantDetailRepositoryImpl;
import com.amallya.doordash.takehome.model.RestaurantDetail;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantDetailPresenter implements RestaurantDetailContract.Presenter{

    private RestaurantDetailRepository restaurantDetailRepository;
    private RestaurantDetail restaurantDetail;
    RestaurantDetailContract.View view;

    public RestaurantDetailPresenter() {
        this.restaurantDetailRepository = new RestaurantDetailRepositoryImpl();
    }

    public void setView(RestaurantDetailContract.View view, int id) {
        this.view = view;
        loadData(id);
    }

    public void loadData(int restaurantId) {
        if (view != null) {
            restaurantDetailRepository.getRestaurantDetail(restaurantId).subscribe(
                    restaurantDetails -> {
                        restaurantDetail = restaurantDetails;
                        refreshUi();
                    }, throwable -> {
                        throwable.printStackTrace();
                    });
        }
    }

    public void refreshUi() {
        if (view != null) {
            view.updateData(restaurantDetail);
        }
    }

    public void onDestroy() {
        view = null;
    }

}
