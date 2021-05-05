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
 * Use the {@link HomeFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("Link","Home"));
        categoryModelList.add(new CategoryModel("Link","Electronics"));
        categoryModelList.add(new CategoryModel("Link","Appliances"));
        categoryModelList.add(new CategoryModel("Link","Furniture"));
        categoryModelList.add(new CategoryModel("Link","Fashion"));
        categoryModelList.add(new CategoryModel("Link","Toys"));
        categoryModelList.add(new CategoryModel("Link","Sports"));
        categoryModelList.add(new CategoryModel("Link","Wall Arts"));
        categoryModelList.add(new CategoryModel("Link","Books"));
        categoryModelList.add(new CategoryModel("Link","Shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

        /////// Banner Slider
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.home,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.error_icon,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.black_cart,"#ffffff"));
        sliderModelList.add(new SliderModel(R.mipmap.profile_placeholder,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.home,"#ffffff"));

        sliderModelList.add(new SliderModel(R.mipmap.error_icon,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner, "#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_email,"#ffffff"));

        /////// Banner Slider

        /////// Horizontal Product Layout

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();

        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.phone_image, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.black_cart, "Google Pixel 2", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.error_icon, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.green_email, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.phone_image, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.red_email, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.home, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.mipmap.bell, "Google Pixel XL3", "SD 625 Processor", "Rs. 5999"));

        /////// Horizontal Product Layout

        ////////////////////////////////

        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals Of The Day" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Trending" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#00ff00"));
        homePageModelList.add(new HomePageModel(3, "Recommendations" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.banner, "#ffff00"));
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#ff0000"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////////////////////////

        return view;
    }
}