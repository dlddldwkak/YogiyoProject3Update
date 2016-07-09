package com.example.user.yogiyoproject;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TabLayout tabLayout;
    ViewPager viewPager;
    SecondAdapter adapter;
    Toolbar toolbar;
    SearchView searchView;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle toggle;
    Spinner mSpinnerRank;
    Spinner mSpinnerPay;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = (Toolbar) findViewById(R.id.logo_toolbar);
        setSupportActionBar(toolbar);


        mSpinnerRank = (Spinner) findViewById(R.id.toolbar_spinner_lank);
        mSpinnerPay = (Spinner) findViewById(R.id.toolbar_spinner_pay);

        ArrayAdapter<String> maArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice);
        mSpinnerRank.setAdapter(maArrayAdapter);

        mSpinnerPay.setAdapter(maArrayAdapter);

        String[] lists = getResources().getStringArray(R.array.spinner_arrange);
        for (int i = 0; i < lists.length; i++) {
            maArrayAdapter.add(lists[i]);
        }


        mDrawerLayout = (DrawerLayout) findViewById(R.id.second_drawer_layout);

        toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.second_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        position = getIntent().getIntExtra("category", 0);

        tabLayout = (TabLayout) findViewById(R.id.second_tabLayout);

        viewPager = (ViewPager) findViewById(R.id.second_viewPager);

        adapter = new SecondAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.removeAllTabs();
        initTab();
        
        viewPager.setCurrentItem(position);
    }

    public void initTab() {

        /*
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
        }*/


        // 제목하나 넣을탭이라면 차라리 이렇게 하는 것이 효율
        // 하지만 이미지나 글자의 색깔이나 할 경우에는 view를 따로 정의하는 것이 낫다.
        String[] tabTileList = getResources().getStringArray(R.array.foodName);

        for (int i = 0; i < tabTileList.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabTileList[i]), i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delivery, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.edittext_search_video));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

  /*   case 처리!!
     if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
