package com.worldremit.kata.domain;

/**
 * Created by kannanka on 26/06/2016.
 */
public class DiscountRule {

    public DiscountRule(String itemName, double discountPrice,long itemCount ){
        this.itemName = itemName;
        this.discountPrice = discountPrice;
        this.itemCount = itemCount;
    }
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public long getItemCount() {
        return itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }

    private double discountPrice;
    private long itemCount;
}
