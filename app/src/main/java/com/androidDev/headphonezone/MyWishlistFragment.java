package com.androidDev.headphonezone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyWishlistFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyWishlistFragment extends Fragment {

    private RecyclerView wishlistRecyclerView;


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerView = view.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.mipmap.phone_image,"Pixel XL", 3, "3", 2014, "Rs. 49999/-", "Rs. 59999/-", "Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.mipmap.phone_image,"Pixel XL", 2, "4", 201, "Rs. 49999/-", "Rs. 59999/-", "Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.mipmap.phone_image,"Pixel XL", 1, "5", 24, "Rs. 49999/-", "Rs. 59999/-", "Cash On Delivery"));
        wishlistModelList.add(new WishlistModel(R.mipmap.phone_image,"Pixel XL", 0, "1", 14, "Rs. 49999/-", "Rs. 59999/-", "Pay With Card"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList);
        wishlistRecyclerView.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();

        return view;
    }
}