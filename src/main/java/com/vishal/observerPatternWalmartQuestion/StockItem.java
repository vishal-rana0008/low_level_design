package com.vishal.observerPatternWalmartQuestion;

public class StockItem {
    String name;
    String price;
    String color;

    public StockItem(String name, String price, String color) {
        this.color = color;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
