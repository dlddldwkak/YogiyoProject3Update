package com.example.user.yogiyoproject;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;

import com.example.user.yogiyoproject.categoty.CategoryFragment;
import com.example.user.yogiyoproject.deliveryList.DeliveryFragment;

public class MainActivity extends AppCompatActivity {

    CategoryFragment categoryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryFragment = new CategoryFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_container, categoryFragment);
        ft.commit();
    }


}
