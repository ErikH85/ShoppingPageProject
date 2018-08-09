package com.gavlehudik.shopping;

public class Order {
    //Fixa en order-klass, för att visa upp ett kvitto i BS
    //den här utvecklas i develop som sedan ska mergas ihop med BS
    private int orderID;
    private String orderName;
    private int price;
    private int quantity;

    public Order(int orderID, String orderName, int price, int quantity){
        this.orderID = orderID;
        this.orderName = orderName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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
}
