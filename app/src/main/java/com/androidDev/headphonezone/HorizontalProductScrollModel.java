package com.androidDev.headphonezone;

public class HorizontalProductScrollModel {

    private int prooductImage;
    private String productTitle;
    private String productDescription;
    private String productPrice;

    public HorizontalProductScrollModel(int prooductImage, String productTitle, String productDescription, String productPrice) {
        this.prooductImage = prooductImage;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getProoductImage() {
        return prooductImage;
    }

    public void setProoductImage(int prooductImage) {
        this.prooductImage = prooductImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
