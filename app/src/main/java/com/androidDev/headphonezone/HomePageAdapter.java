package com.androidDev.headphonezone;

import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;
            case 1:
                return HomePageModel.STRIP_AD_BANNER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case HomePageModel.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_ad_layout, viewGroup, false);
                return new BannerSliderViewHolder(bannerSliderView);
            case HomePageModel.STRIP_AD_BANNER:
                View stripAdView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_ad_layout, viewGroup, false);
                return new StripAdBannerViewHolder(stripAdView);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout, viewGroup, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridProductView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
                return new GridProductViewHolder(gridProductView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNER_SLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) viewHolder).setBannerSliderViewPager(sliderModelList);
                break;
            case HomePageModel.STRIP_AD_BANNER:
                int resource = homePageModelList.get(position).getResource();
                String color = homePageModelList.get(position).getBackgroundColor();
                ((StripAdBannerViewHolder) viewHolder).setStripAd(resource, color);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontalLayoutTitle = homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModel> horizontalProductScrollModelList = homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((HorizontalProductViewHolder) viewHolder).setHorizontalProductLayout(horizontalProductScrollModelList, horizontalLayoutTitle);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String GridLayoutTitle = homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModel> gridProductScrollModelList = homePageModelList.get(position).getHorizontalProductScrollModelList();
                ((GridProductViewHolder) viewHolder).setGridProductLayout(gridProductScrollModelList, GridLayoutTitle);
                break;
            default:
                return;

        }

    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }


    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderViewPager;
        private List<SliderModel> sliderModelList;
        private int currentPage = 2;
        private Timer timer;
        private final long DELAY_TIME = 3000;
        private final long PERIOD_TIME = 3000;

        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_view_pager);
        }

        private void setBannerSliderViewPager(final List<SliderModel> sliderModelList) {

            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            bannerSliderViewPager.setAdapter(sliderAdapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);
            bannerSliderViewPager.setCurrentItem(currentPage);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        pageLooper(sliderModelList);
                    }
                }
            };
            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

            startBannerSlideShow(sliderModelList);

            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(sliderModelList);
                    stopBannerSlideShow();

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startBannerSlideShow(sliderModelList);
                    }

                    return false;
                }
            });

        }

        private void pageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage, false);
            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannerSliderViewPager.setCurrentItem(currentPage, false);
            }
        }

        public void startBannerSlideShow(final List<SliderModel> sliderModelList) {
            Handler handler = new Handler();
            Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannerSliderViewPager.setCurrentItem(currentPage++);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }

        private void stopBannerSlideShow() {
            timer.cancel();
        }

    }

    public class StripAdBannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView stripAdImage;
        private ConstraintLayout stripAdContainer;

        public StripAdBannerViewHolder(@NonNull View itemView) {
            super(itemView);

            stripAdImage = itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer = itemView.findViewById(R.id.strip_ad_container);


        }

        private void setStripAd(int resource, String color) {
            stripAdImage.setImageResource(resource);
            stripAdImage.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {

        private TextView horizontalLayoutTitle;
        private Button horizontalLayoutViewAllButton;
        private RecyclerView horizontalRecyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontalLayoutTitle = itemView.findViewById(R.id.horizontal_srcoll_layout_title);
            horizontalLayoutViewAllButton = itemView.findViewById(R.id.horizontal_scroll_view_all_btn);
            horizontalRecyclerView = itemView.findViewById(R.id.horizonatal_scroll_layout_recyclerview);
        }

        private void setHorizontalProductLayout(List<HorizontalProductScrollModel> horizontalProductScrollModelList, String title) {

            horizontalLayoutTitle.setText(title);

            if (horizontalProductScrollModelList.size() > 8) {
                horizontalLayoutViewAllButton.setVisibility(View.VISIBLE);
            } else {
                horizontalLayoutViewAllButton.setVisibility(View.INVISIBLE);
            }

            HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);

            horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();
        }
    }

    public class GridProductViewHolder extends RecyclerView.ViewHolder {

        private TextView gridLayoutTitle;
        private Button gridLayoutViewAllBtn;
        private GridView gridView;

        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);

            gridLayoutTitle = itemView.findViewById(R.id.grid_product_layout_title);
            gridLayoutViewAllBtn = itemView.findViewById(R.id.grid_product_layout_viewall_btn);
            gridView = itemView.findViewById(R.id.grid_product_layout_gridview);

        }

        private void setGridProductLayout(List<HorizontalProductScrollModel> horizontalProductScrollModelList ,String title) {

            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));

        }
    }
}
