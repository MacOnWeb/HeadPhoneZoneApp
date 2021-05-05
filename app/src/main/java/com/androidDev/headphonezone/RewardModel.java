package com.androidDev.headphonezone;

public class RewardModel {

    private String title;
    private String exipryDate;
    private String couponBody;

    public RewardModel(String title, String exipryDate, String couponBody) {
        this.title = title;
        this.exipryDate = exipryDate;
        this.couponBody = couponBody;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExipryDate() {
        return exipryDate;
    }

    public void setExipryDate(String exipryDate) {
        this.exipryDate = exipryDate;
    }

    public String getCouponBody() {
        return couponBody;
    }

    public void setCouponBody(String couponBody) {
        this.couponBody = couponBody;
    }
}
