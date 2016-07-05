package com.example.user.yogiyoproject.tabView;

/**
 * Created by user on 2016-07-02.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.user.yogiyoproject.R;


public class KoreaFoodTabView extends FrameLayout {

    public KoreaFoodTabView(Context context) {
        super(context);
        init();
    }

    public KoreaFoodTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KoreaFoodTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        inflate(getContext(), R.layout.tab_view_koreafood,this);
    }
}