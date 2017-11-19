package com.hollywood.fixtures;

/**
 * Created by andylongstaffe on 19/11/2017.
 */
public class Item {

    String name;
    Integer price;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
