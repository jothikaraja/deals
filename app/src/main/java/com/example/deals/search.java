package com.example.deals;
import java.util.List;

 class pdata {

    private String product_title;
    private boolean can_compare;
    private float product_lowest_price;
    private String product_link;
    private String product_id;
    private String product_category;
    private String product_subcategory;
    private float product_rating;
    private String product_image;

    public String getProduct_title() {
        return product_title;
    }

    public boolean isCan_compare() {
        return can_compare;
    }

    public float getProduct_lowest_price() {
        return product_lowest_price;
    }

    public String getProduct_link() {
        return product_link;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_category() {
        return product_category;
    }

    public String getProduct_subcategory() {
        return product_subcategory;
    }

    public float getProduct_rating() {
        return product_rating;
    }

    public String getProduct_image() {
        return product_image;
    }
}
class  pprice{
     private int min;
     private int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
class  bbrand{
     private String name;
     private String property;
     private String doc_count;

    public String getName() {
        return name;
    }

    public String getProperty() {
        return property;
    }

    public String getDoc_count() {
        return doc_count;
    }
}
class ffilter{
    private pprice price;
     private bbrand brand;

    public pprice getPrice() {
        return price;
    }

    public bbrand getBrand() {
        return brand;
    }
}
class mmeta{
     private long items;
     private ffilter filter;

    public long getItems() {
        return items;
    }

    public ffilter getFilter() {
        return filter;
    }
}
public class search{
    List<pdata> data;
    mmeta meta;

    public List<pdata> getData() {
        return data;
    }

    public mmeta getMeta() {
        return meta;
    }
}
