package com.worldremit.kata.domain;

/**
 * Created by kannanka on 26/06/2016.
 */
public class Item {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

}
