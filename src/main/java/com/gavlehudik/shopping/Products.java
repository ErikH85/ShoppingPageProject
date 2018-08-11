package com.gavlehudik.shopping;

public class Products {
    public String productName;
    public int price;
    public int ID;
    public String imgSource;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Products(String productName, int price, int ID, String imgSource) {
        this.productName = productName;
        this.price = price;
        this.ID = ID;
        this.imgSource = imgSource;
    }
}
