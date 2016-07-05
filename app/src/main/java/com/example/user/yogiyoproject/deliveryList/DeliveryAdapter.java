package com.example.user.yogiyoproject.deliveryList;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.yogiyoproject.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016-07-02.
 */
public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryItemHolder> {

    List<DeliveryItemData> items = new ArrayList<>();

    public void add(DeliveryItemData deliveryItemData){
        items.add(deliveryItemData);
        notifyDataSetChanged();
    }

    public static final int VIEW_TYPE_01=0;

    @Override
    public DeliveryItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case VIEW_TYPE_01:
                View view = inflater.inflate(R.layout.item_delivery,parent,false);
                return new DeliveryItemHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(DeliveryItemHolder holder, int position) {

        holder.setDeliveryData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
