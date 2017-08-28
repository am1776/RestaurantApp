package com.amallya.doordash.takehome.data.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.amallya.doordash.takehome.data.db.DatabaseHelper;
import com.amallya.doordash.takehome.model.Restaurant;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anmallya on 8/27/2017.
 */

public class RestaurantIntentService extends IntentService {

    public RestaurantIntentService() {
        super("BulkInsertionService");
    }

    public static final String RESTAURANT_LIST = "RESTAURANT_LIST";

    @Override
    protected void onHandleIntent(Intent intent) {
        List<Restaurant> list = (ArrayList<Restaurant>) intent.getSerializableExtra(RESTAURANT_LIST);
        insertRestaurantsToDb(list);
        this.stopSelf();
    }

    private void insertRestaurantsToDb(List<Restaurant> list){
        Dao<Restaurant, Integer> dao = OpenHelperManager.getHelper(this, DatabaseHelper.class).getRestaurantListDao();
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
}