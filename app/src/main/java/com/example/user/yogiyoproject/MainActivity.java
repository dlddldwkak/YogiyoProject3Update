package com.example.user.yogiyoproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.user.yogiyoproject.categoty.CategoryFragment;

public class MainActivity extends AppCompatActivity {

    CategoryFragment categoryFragment;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.logo_toolbar);
        setSupportActionBar(toolbar);

        categoryFragment = new CategoryFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_container, categoryFragment);
        ft.commit();
    }


}
