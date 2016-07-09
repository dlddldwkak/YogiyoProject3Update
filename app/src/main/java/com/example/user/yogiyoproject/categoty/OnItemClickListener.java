package com.example.user.yogiyoproject.categoty;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public interface OnItemClickListener {
    void OnItemClicked(RecyclerView.ViewHolder holder,
                       View view, CategoryItemData itemData, int position);
}
