package com.example.user.yogiyoproject.categoty;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by user on 2016-07-01.
 */
public interface OnItemClickListener {
    public void OnItemClicked(RecyclerView.ViewHolder holder,
                              View view, CategoryItemData itemData, int position);
}
