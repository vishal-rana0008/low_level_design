package com.vishal.vendingMachine.model;

import com.vishal.vendingMachine.enums.ItemType;

public class Item {
    private String name;
    private int itemCode;
    private int price;
    private ItemType itemType;

    public Item(String name, int itemCode, int price, ItemType itemType) {
        this.name = name;
        this.itemCode = itemCode;
        this.price = price;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public int getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", itemCode=" + itemCode +
                ", price=" + price +
                ", itemType=" + itemType +
                '}';
    }
}
