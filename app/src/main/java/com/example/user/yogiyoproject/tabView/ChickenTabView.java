package com.example.user.yogiyoproject.tabView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.user.yogiyoproject.R;

/**
 * TODO: document your custom view class.
 */
public class ChickenTabView extends FrameLayout{

    public ChickenTabView(Context context) {
        super(context);
        init();
    }

    public ChickenTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChickenTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(){
        inflate(getContext(),R.layout.tab_view_chicken,this);
        TextView textView = (TextView) findViewById(R.id.tab_chicken_name);
        textView.setText("치킨");
    }
}