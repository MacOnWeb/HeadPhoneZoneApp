package com.androidDev.headphonezone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

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

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#000000"));
        homePageModelList.add(new HomePageModel(2, "Deals Of The Day" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Trending" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#00ff00"));
        homePageModelList.add(new HomePageModel(3, "Recommendations" ,horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1, R.drawable.banner, "#ffff00"));
        homePageModelList.add(new HomePageModel(1, R.mipmap.strip_ad, "#ff0000"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ////////////////////////////////

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int  id = item.getItemId();

        if (id == R.id.main_search_icon) {
            //todo search
            return true;
        }else if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}