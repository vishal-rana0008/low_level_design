package com.vishal.vendingMachine.model;

import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int itemCode) {
        for (int i = 0; i <  items.size(); i++) {
            if (items.get(i).getItemCode() == itemCode) {
                items.remove(i);
                break;
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}
