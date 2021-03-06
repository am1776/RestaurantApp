package com.amallya.doordash.takehome.view.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.amallya.doordash.takehome.R;
import com.amallya.doordash.takehome.model.Restaurant;
import com.amallya.doordash.takehome.model.RestaurantDetail;
import com.amallya.doordash.takehome.view.restaurantDetail.RestaurantDetailFragment;
import com.amallya.doordash.takehome.view.restaurantList.RestaurantListFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RestaurantListFragment.OnRestaurantSelectedListener, RestaurantDetailFragment.OnStartListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbarTv)
    TextView toolbarTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("T", "activity on create");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        if (savedInstanceState == null) {
            setupRestaurantListFragment();
        }
    }

    private void setupToolbar(){
        toolbar.setTitle(R.string.toolbar_title_blank);
        setSupportActionBar(toolbar);
    }

    private void setupRestaurantListFragment(){
        toolbarTv.setText(R.string.default_toolbar_title);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_content, new RestaurantListFragment())
                .commit();
    }

    private void setupRestaurantDetailFragment(Restaurant restaurant) {
        RestaurantDetailFragment restaurantDetailFragment = RestaurantDetailFragment.newInstance(restaurant.getId());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_content, restaurantDetailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onRestaurantSelected(Restaurant restaurant){
        setupRestaurantDetailFragment(restaurant);
        //toolbarTv.setText(restaurant.getName());
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();

        // click on icon to go back
        //triangle icon on the main android toolbar.
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStartFragment(){
        toolbarTv.setText(R.string.default_toolbar_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    @Override
    public void onStartDetailFragment(String restaurant){
        toolbarTv.setText(restaurant);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
