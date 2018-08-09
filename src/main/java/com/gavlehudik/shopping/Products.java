package com.gavlehudik.shopping;

public class Products {
    public String productName;
    public int price;

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

    public Products(String produceName, int price) {
        this.productName = produceName;
        this.price = price;
    }
}
