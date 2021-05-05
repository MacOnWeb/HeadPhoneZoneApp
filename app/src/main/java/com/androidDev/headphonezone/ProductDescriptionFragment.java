package com.androidDev.headphonezone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDescriptionFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDescriptionFragment extends Fragment {

    public ProductDescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_description, container, false);
    }
}