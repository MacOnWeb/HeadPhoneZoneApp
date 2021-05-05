package com.androidDev.headphonezone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCartFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCartFragment extends Fragment {

    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;

    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();

        cartItemModelList.add(new CartItemModel(0,R.mipmap.phone_image,"Pixel 2",4,"Rs. 49999/-","Rs. 59999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.phone_image,"Pixel 2",4,"Rs. 42999/-","Rs. 59999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.mipmap.phone_image,"Pixel 2",4,"Rs. 29999/-","Rs. 69999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(1,"Price (3 items)","Rs. 45999/-","Free","Rs. 45999","Rs. 5999/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getContext(),AddAddressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });

        return view;
    }
}