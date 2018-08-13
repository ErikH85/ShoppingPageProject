package com.gavlehudik.shopping;

public class Products {
    public String productName;
    public int price;


    public int ID;
    public String imgSource;
    public int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products(String productName, int price, int ID, String imgSource, int quantity) {
        this.productName = productName;
        this.price = price;
        this.ID = ID;
        this.imgSource = imgSource;
        this.quantity = quantity;
    }
}
