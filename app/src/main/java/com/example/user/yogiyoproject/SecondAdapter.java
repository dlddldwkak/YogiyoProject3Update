package com.example.user.yogiyoproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.yogiyoproject.deliveryList.DeliveryFragment;

/**
 * Created by user on 2016-07-02.
 */
public class SecondAdapter extends FragmentPagerAdapter {

    public SecondAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                DeliveryFragment tab1 = new DeliveryFragment();
                return tab1;
            case 1:
                DeliveryFragment tab2 = new DeliveryFragment();
                return tab2;
            case 2:
                DeliveryFragment tab3 = new DeliveryFragment();
                return tab3;
            case 3:
                DeliveryFragment tab4 = new DeliveryFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
