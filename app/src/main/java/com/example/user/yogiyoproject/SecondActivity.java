package com.example.user.yogiyoproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.user.yogiyoproject.deliveryList.DeliveryFragment;
import com.example.user.yogiyoproject.tabView.ChickenTabView;
import com.example.user.yogiyoproject.tabView.ChinaFoodTabView;
import com.example.user.yogiyoproject.tabView.KoreaFoodTabView;
import com.example.user.yogiyoproject.tabView.SideFoodTabView;

public class SecondActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    SecondAdapter adapter;
    Toolbar toolbar;

    int position;

    DeliveryFragment deliveryFragmentfragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = (Toolbar) findViewById(R.id.logo_toolbar);
        setSupportActionBar(toolbar);

        position = getIntent().getIntExtra("category", 0);
        Log.d("tag", Integer.toString(position));
        /*if(position!=0)

        else
            Log.d("tag","category_name is null");
*/
        tabLayout = (TabLayout) findViewById(R.id.second_tabLayout);

        viewPager = (ViewPager) findViewById(R.id.second_viewPager);

        adapter = new SecondAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.removeAllTabs();
        initTab();
    }

    public void initTab() {


        ChickenTabView chickenTabView = new ChickenTabView(getApplicationContext());
        ChinaFoodTabView chinaFoodTabView = new ChinaFoodTabView(getApplicationContext());
        SideFoodTabView sideFoodTabView = new SideFoodTabView(getApplicationContext());
        KoreaFoodTabView koreaFoodTabView = new KoreaFoodTabView(getApplicationContext());

        View[] tabViews = {chickenTabView, chinaFoodTabView, sideFoodTabView, koreaFoodTabView};
        for (int i = 0; i < tabViews.length; i++) {

            if (i == position)
                tabLayout.addTab(tabLayout.newTab().setCustomView(tabViews[i]), i, true);
            else
                tabLayout.addTab(tabLayout.newTab().setCustomView(tabViews[i]), i);
        }

    }
}
