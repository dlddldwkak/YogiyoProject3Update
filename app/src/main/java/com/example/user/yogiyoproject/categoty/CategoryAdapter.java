package com.example.user.yogiyoproject.categoty;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.yogiyoproject.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryItemHolder> {

    public static final int VIEW_TYPE_ITEM = 0;
    List<CategoryItemData> items = new ArrayList<>();
    OnItemClickListener mClickListener;

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public void add(CategoryItemData itemData){
        items.add(itemData);
        notifyDataSetChanged();
    }

    public void setOnItemClickLister(OnItemClickListener onItemClickListener){
        mClickListener = onItemClickListener;
    }

    @Override
    public CategoryItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view  = null;
        switch (viewType) {
            case VIEW_TYPE_ITEM:
                view = inflater.inflate(R.layout.item_category,parent,false);
                return new CategoryItemHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CategoryItemHolder holder, int position) {
        holder.setItemData(items.get(position));
        holder.setOnItemClickListener(mClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
