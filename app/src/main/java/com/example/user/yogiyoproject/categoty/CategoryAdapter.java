package com.example.user.yogiyoproject.categoty;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.yogiyoproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016-07-01.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryItemHolder> {

    List<CategoryItemData> items = new ArrayList<>();

    public static final int VIEW_TYPE_ITEM = 0;

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    OnItemClickListener mClickListener;

    public void add(CategoryItemData itemData){
        //Log.d("tag","add");
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
        //Log.d("tag","123");
        holder.setItemData(items.get(position));
        holder.setOnItemClickListener(mClickListener);
    }

    @Override
    public int getItemCount() {
        //Log.d("tag","size : "+Integer.toString(items.size()));
        return items.size();
    }
}
