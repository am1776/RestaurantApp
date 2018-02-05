package com.amallya.doordash.takehome;

import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListContract;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by anmallya on 2/4/2018.
 */

public class RestaurantListPresenterTest{

    private static List<Restaurant> RESTAURANTS = new ArrayList<>();
    private static List<Restaurant> EMPTY_RESTAURANTS = new ArrayList<>();

    @Mock
    private RestaurantRepository mRestaurantRepository;

    @Mock
    private RestaurantListContract.View mRestaurantListView;

    private RestaurantListPresenter mRestaurantListPresenter;

    @Before
    public void setupRestaurantPresenter() {
        MockitoAnnotations.initMocks(this);
        mRestaurantListPresenter = new RestaurantListPresenter(mRestaurantRepository, mRestaurantListView);
        RESTAURANTS.add(new Restaurant("Rest 1")); RESTAURANTS.add(new Restaurant("Rest 2"));
    }

    /*
            when load data gets called, load data from the db if it exists
     */
    @Test
    public void loadRestaurantsFromRepoAndLoadIntoView() {
        when(mRestaurantRepository.getRestaurantList()).thenReturn(Observable.just(RESTAURANTS));
        mRestaurantListPresenter.loadData();
        verify(mRestaurantRepository).getRestaurantList();
        verify(mRestaurantListView).updateData(RESTAURANTS);
    }


    /*
            when data already exists in memory, do not call the repo
     */
    @Test
    public void loadRestaurantsMemory() {
        when(mRestaurantRepository.getRestaurantList()).thenReturn(Observable.just(RESTAURANTS));
        mRestaurantListPresenter.loadData();
        mRestaurantListPresenter.loadData();
        mRestaurantListPresenter.loadData();
        verify(mRestaurantRepository, atMost(1)).getRestaurantList();
        verify(mRestaurantListView, atLeast(3)).updateData(RESTAURANTS);
    }

    /*
            when load data gets called, if data does not exist in the DB, load it from the network and then insert to DB
    */
    @Test
    public void loadRestaurantsFromRepoNetworkAndLoadIntoView() {
        when(mRestaurantRepository.getRestaurantList()).thenReturn(Observable.just(EMPTY_RESTAURANTS));
        when(mRestaurantRepository.getRestaurantListNetwork()).thenReturn(Observable.just(RESTAURANTS));
        mRestaurantListPresenter.loadData();
        verify(mRestaurantRepository).getRestaurantList();
        verify(mRestaurantRepository).getRestaurantListNetwork();
        verify(mRestaurantRepository).insertRestaurantsToDb(RESTAURANTS);
        verify(mRestaurantListView).updateData(RESTAURANTS);
    }
}
