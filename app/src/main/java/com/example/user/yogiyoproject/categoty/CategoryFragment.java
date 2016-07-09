package com.example.user.yogiyoproject.categoty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.yogiyoproject.R;
import com.example.user.yogiyoproject.SecondActivity;

public class CategoryFragment extends Fragment {

    public int[] images = {R.drawable.chicken, R.drawable.chinafood,
            R.drawable.sidefood, R.drawable.koreafood};
    public String[] names;
    RecyclerView categoryRecyclerView;
    CategoryAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        categoryRecyclerView = (RecyclerView) view.findViewById(R.id.category_recyclerView);
        mAdapter = new CategoryAdapter();

        mAdapter.setOnItemClickLister(new OnItemClickListener() {
            @Override
            public void OnItemClicked(RecyclerView.ViewHolder holder, View view, CategoryItemData itemData, int position) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                intent.putExtra("category", position);
                startActivity(intent);
            }
        });

        categoryRecyclerView.setAdapter(mAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });


        categoryRecyclerView.setLayoutManager(gridLayoutManager);
        initData();
        return view;
    }

    public void initData() {
        names = getResources().getStringArray(R.array.foodName);

        for (int i = 0; i < images.length; i++) {
            CategoryItemData cd = new CategoryItemData();
            cd.setName(names[i]);
            cd.setIconId(images[i]);
            mAdapter.add(cd);
        }
    }
}
