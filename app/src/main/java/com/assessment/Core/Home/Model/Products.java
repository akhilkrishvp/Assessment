package com.assessment.Core.Home.Model;

/**
 * Created by akhil on 12/10/18.
 */

public class Products {
    private int id;
    private String productName;
    private String productUrl;
    private double price;

    public Products(int id, String title, String url, int price) {
        this.id = id;
        this.productName = title;
        this.productUrl = url;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
