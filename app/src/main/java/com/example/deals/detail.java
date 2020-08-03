package com.example.deals;

public class detail {
    private String product_store;
    private String product_store_logo;
    private String product_price;
    private String product_store_url;

    public detail(String product_store, String product_store_logo, String product_price, String product_store_url) {
        this.product_store = product_store;
        this.product_store_logo = product_store_logo;
        this.product_price = product_price;
        this.product_store_url = product_store_url;
    }

    public String getProduct_store() {
        return product_store;
    }

    public String getProduct_store_logo() {
        return product_store_logo;
    }

    public String getProduct_price() {
        return product_price;
    }

    public String getProduct_store_url() {
        return product_store_url;
    }
}
