package com.example.deals;

public class card {

    private String product_name;
    private String price;
    private String image;
    private String Button;

    public card(String product_name, String price, String image,String Button) {
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.Button=Button;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getButton() {
        return Button;
    }
}
