package com.junky.mymall.entity;


public class OrderItem {

    private String itemId;
    private String productId;
    private long productQuility;
    private double itemSum;
    private String orderId;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    public long getProductQuility() {
        return productQuility;
    }

    public void setProductQuility(long productQuility) {
        this.productQuility = productQuility;
    }


    public double getItemSum() {
        return itemSum;
    }

    public void setItemSum(double itemSum) {
        this.itemSum = itemSum;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
