package com.example.user.yogiyoproject.deliveryList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.yogiyoproject.R;

public class DeliveryFragment extends Fragment {
    /*// TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DeliveryFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DeliveryFragment newInstance(String param1, String param2) {
        DeliveryFragment fragment = new DeliveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/


    RecyclerView recyclerView;
    DeliveryAdapter deliveryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.delivery_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        deliveryAdapter = new DeliveryAdapter();
        recyclerView.setAdapter(deliveryAdapter);

        initData();
        return view;
    }

    public void initData() {
        String[] names = getResources().getStringArray(R.array.deliveryList);

        DeliveryItemData deliveryItemData = new DeliveryItemData();
        deliveryItemData.setName(names[0]);
        deliveryItemData.setIconId(R.drawable.list1);
        deliveryAdapter.add(deliveryItemData);

        DeliveryItemData deliveryItemData1 = new DeliveryItemData();
        deliveryItemData1.setName(names[1]);
        deliveryItemData1.setIconId(R.drawable.list2);
        deliveryAdapter.add(deliveryItemData1);

        for (int i = 2; i < names.length; i++) {
            DeliveryItemData deliveryItemData2 = new DeliveryItemData();
            deliveryItemData2.setName(names[i]);
            deliveryItemData2.setIconId(R.mipmap.ic_launcher);
            deliveryAdapter.add(deliveryItemData2);
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
    }*/

    /*@Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
   /* public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
