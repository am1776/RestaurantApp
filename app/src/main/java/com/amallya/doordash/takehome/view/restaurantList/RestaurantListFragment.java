package com.amallya.doordash.takehome.view.restaurantList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.amallya.doordash.takehome.R;
import com.amallya.doordash.takehome.data.repository.RestaurantRepository;
import com.amallya.doordash.takehome.model.Restaurant;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantListFragment extends Fragment implements RestaurantListContract.View{

    private OnRestaurantSelectedListener mListener;
    private RestaurantListPresenter restaurantListPresenter;

    @BindView(R.id.restaurantListRv)
    RecyclerView restaurantRv;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    public RestaurantListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantListPresenter = new RestaurantListPresenter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurant_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mListener.onStartFragment();
        setupUi();
        restaurantListPresenter.setView(this);
    }

    @Override
    public void onDestroy() {
        restaurantListPresenter.onDestroy();
        super.onDestroy();
    }

    private void setupUi(){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        restaurantRv.setLayoutManager(manager);
        RestaurantListAdapter adapter = new RestaurantListAdapter(
                new ArrayList<Restaurant>(), getActivity(), new RestaurantListAdapter.RestaurantClickListener(){
            @Override
            public void onRestaurantClick(Restaurant restaurant) {
                mListener.onRestaurantSelected(restaurant);
            }

            @Override
            public void onRestaurantFavorited(Restaurant restaurant) {
                restaurantListPresenter.onRestaurantFavorited(restaurant);
            }
        });
        restaurantRv.setAdapter(adapter);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateData(List<Restaurant> list){
        progressBar.setVisibility(View.INVISIBLE);
        ((RestaurantListAdapter) restaurantRv.getAdapter()).replaceDataSet(list);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRestaurantSelectedListener) {
            mListener = (OnRestaurantSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + R.string.restaurant_listener_error_msg);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnRestaurantSelectedListener {
        void onRestaurantSelected(Restaurant restaurant);
        void onStartFragment();
    }
}
