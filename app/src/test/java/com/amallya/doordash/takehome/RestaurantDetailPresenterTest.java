package com.amallya.doordash.takehome;

import com.amallya.doordash.takehome.data.repository.RestaurantDetailRepository;
import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.model.RestaurantDetail;
import com.amallya.doordash.takehome.view.restaurantDetail.RestaurantDetailContract;
import com.amallya.doordash.takehome.view.restaurantDetail.RestaurantDetailPresenter;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListContract;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by anmallya on 2/4/2018.
 */

public class RestaurantDetailPresenterTest {

    private static RestaurantDetail RESTAURANT_DETAIL;
    private static final int REST_ID = 2;

    @Mock
    private RestaurantDetailRepository mRestaurantDetailRepository;

    @Mock
    private RestaurantDetailContract.View mRestaurantDetailView;

    private RestaurantDetailPresenter mRestaurantDetailPresenter;

    @Before
    public void setupRestaurantPresenter() {
        MockitoAnnotations.initMocks(this);
        mRestaurantDetailPresenter = new RestaurantDetailPresenter(mRestaurantDetailRepository, mRestaurantDetailView);
        RESTAURANT_DETAIL = new RestaurantDetail();
    }

    /*
            when load data gets called, load data from the Network
     */
    @Test
    public void loadRestaurantDetailFromRepoAndLoadIntoView() {
        when(mRestaurantDetailRepository.getRestaurantDetail(REST_ID)).thenReturn(Observable.just(RESTAURANT_DETAIL));
        mRestaurantDetailPresenter.loadData(REST_ID);
        verify(mRestaurantDetailRepository).getRestaurantDetail(REST_ID);
        verify(mRestaurantDetailView).updateData(RESTAURANT_DETAIL);
    }
}
