package com.example.user.yogiyoproject.categoty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.yogiyoproject.MainActivity;
import com.example.user.yogiyoproject.R;
import com.example.user.yogiyoproject.SecondActivity;
import com.example.user.yogiyoproject.deliveryList.DeliveryFragment;


public class CategoryFragment extends Fragment {
    /*// TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/

    RecyclerView rv;
    CategoryAdapter mAdapter;

    public int[] images = {R.drawable.chicken, R.drawable.chinafood,
            R.drawable.sidefood, R.drawable.koreafood};
    public String[] names;
/*
    //private OnFragmentInteractionListener mListener;


    public CategoryFragment() {
        // Required empty public constructor
    }

    */

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     *//*
    // TODO: Rename and change types and number of parameters
    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        rv = (RecyclerView) view.findViewById(R.id.category_recyclerView);
        mAdapter = new CategoryAdapter();

        mAdapter.setOnItemClickLister(new OnItemClickListener() {
            @Override
            public void OnItemClicked(RecyclerView.ViewHolder holder, View view, CategoryItemData itemData, int position) {
                Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), SecondActivity.class);
                intent.putExtra("category", position);
                Log.d("tag",Integer.toString(position));
                startActivity(intent);
            }
        });

        rv.setAdapter(mAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });


        rv.setLayoutManager(gridLayoutManager);
        initData();
        return view;
    }

    public void initData() {
        names = getResources().getStringArray(R.array.foodName);

        for (int i = 0; i < images.length; i++) {
            //Log.d("tag1", "image id = " + Integer.toString(images[i]));
            //Log.d("tag1", "name = " + names[i]);
            CategoryItemData cd = new CategoryItemData();
            cd.setName(names[i]);
            cd.setIconId(images[i]);
            mAdapter.add(cd);
        }
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    *//**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
