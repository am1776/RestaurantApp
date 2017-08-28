package com.amallya.doordash.takehome.data.repository.impl;


import android.content.Context;
import android.util.Log;

import com.amallya.doordash.takehome.data.db.DatabaseHelper;
import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.data.service.RestaurantService;
import com.amallya.doordash.takehome.data.service.ServiceApi;
import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.utils.Params;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by anmallya on 8/26/2017.
 */

public class RestaurantRepositoryImpl implements RestaurantRepository {

    Context mContext;
    private DatabaseHelper databaseHelper = null;

    public RestaurantRepositoryImpl(Context context) {
        mContext = context;
    }

    public static final String IS_FAVORITED_COLUMN = "isFavorited";
    public static final String ID_COLUMN = "id";


    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(mContext, DatabaseHelper.class);
        }
        return databaseHelper;
    }

    @Override
    public Observable<List<Restaurant>> getRestaurantList() {
        Observable.OnSubscribe<List<Restaurant>> onSubscribe = subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(getAllRestaurantsFromDb());
                    subscriber.onCompleted();
                }
            } catch (Exception e) {
                subscriber.onError(e);
            }
        };
        return Observable.create(onSubscribe)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Restaurant>> getRestaurantListNetwork() {
        RestaurantService apiService = ServiceApi.getInstance().getUserService();
        Observable<List<Restaurant>> restaurantList =
                apiService.getRestaurantList(Params.LAT, Params.LNG);
        return restaurantList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void insertRestaurantsToDb(List<Restaurant> list){
        /*
        Intent intentEv= new Intent(Intent.ACTION_INSERT, null, mContext.getApplicationContext(), RestaurantIntentService.class);
        intentEv.putExtra(RestaurantIntentService.RESTAURANT_LIST, (ArrayList<Restaurant> list);
        mContext.startService(intentEv);
        */

        Dao<Restaurant, Integer> dao = getHelper().getRestaurantListDao();
        for(int i = 0; i < list.size(); i++){
            Restaurant restaurant = list.get(i);
            try {
                dao.create(restaurant);
                Log.i(DatabaseHelper.class.getName(),
                        "created new entries in onCreate: " + restaurant.getName());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onRestaurantFavorited(Restaurant restaurant){
        Dao<Restaurant, Integer> dao = getHelper().getRestaurantListDao();
        UpdateBuilder<Restaurant, Integer> updateBuilder = dao.updateBuilder();
        try {
            updateBuilder.where().eq(ID_COLUMN, restaurant.getId());
            updateBuilder.updateColumnValue(IS_FAVORITED_COLUMN, restaurant.getIsFavorited());
            updateBuilder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Restaurant> getAllRestaurantsFromDb(){
        Dao<Restaurant, Integer> dao = getHelper().getRestaurantListDao();
        QueryBuilder<Restaurant, Integer> queryBuilder = dao.queryBuilder();
        List<Restaurant> list = null;
        try {
            queryBuilder.orderBy(IS_FAVORITED_COLUMN, false);
            list = queryBuilder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

