package com.gavlehudik.shopping;

public class Cart {
    String productName;
    String cost;
    String quantity;

    public Cart(String productName, String cost, String quantity) {
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
