package com.example.user.yogiyoproject.tabView;

/**
 * Created by user on 2016-07-02.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.user.yogiyoproject.R;

public class ChinaFoodTabView extends FrameLayout {

    public ChinaFoodTabView(Context context) {
        super(context);
        init();
    }

    public ChinaFoodTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChinaFoodTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        inflate(getContext(), R.layout.tab_view_chinafood,this);
    }
}
