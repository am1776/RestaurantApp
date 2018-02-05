package com.amallya.doordash.takehome.view.restaurantDetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amallya.doordash.takehome.R;
import com.amallya.doordash.takehome.data.repository.RestaurantDetailRepository;
import com.amallya.doordash.takehome.data.repository.impl.RestaurantDetailRepositoryImpl;
import com.amallya.doordash.takehome.data.service.RestaurantService;
import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.model.RestaurantDetail;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListAdapter;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListFragment;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantDetailFragment extends Fragment implements RestaurantDetailContract.View {

    private static final String RESTAURANT_ID = "RESTAURANT_ID";
    private int restaurantId;

    @BindView(R.id.tvPhone)
    TextView tvPhone;

    @BindView(R.id.tvDeliveryFee)
    TextView tvDeliveryFee;

    @BindView(R.id.tvServiceRate)
    TextView tvServiceRate;

    @BindView(R.id.tvYelpReviewCount)
    TextView tvYelpReviewCount;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private RestaurantDetailContract.Presenter restaurantDetailPresenter;

    public RestaurantDetailFragment() {
    }

    public static RestaurantDetailFragment newInstance(int restaurantId) {
        RestaurantDetailFragment fragment = new RestaurantDetailFragment();
        Bundle args = new Bundle();
        args.putInt(RESTAURANT_ID, restaurantId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            restaurantId = getArguments().getInt(RESTAURANT_ID);
        }
        restaurantDetailPresenter = new RestaurantDetailPresenter(new RestaurantDetailRepositoryImpl(), this);
    }


    private OnStartListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RestaurantDetailFragment.OnStartListener) {
            mListener = (RestaurantDetailFragment.OnStartListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + R.string.restaurant_listener_error_msg);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        restaurantDetailPresenter.loadData(restaurantId);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void updateData(RestaurantDetail restaurantDetail){
        updateView(restaurantDetail);
    }

    private void updateView(RestaurantDetail restaurantDetail){
        mListener.onStartDetailFragment(restaurantDetail.getName());
        progressBar.setVisibility(View.INVISIBLE);
        tvPhone.setText(restaurantDetail.getPhoneNumber());
        tvDeliveryFee.setText(convertDeliveryFeeToDollars(restaurantDetail.getDeliveryFee()));
        tvServiceRate.setText(restaurantDetail.getServiceRate()+"");
        tvYelpReviewCount.setText(restaurantDetail.getYelpReviewCount()+"");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
    }

    @Override
    public void onDestroy() {
        restaurantDetailPresenter.onDestroy();
        super.onDestroy();
    }

    private String convertDeliveryFeeToDollars(Integer fee){
        Double dFee = Double.parseDouble(fee+"")/100;
        return "$"+dFee;
    }

    public interface OnStartListener {
        void onStartDetailFragment(String restaurant);
    }
}
