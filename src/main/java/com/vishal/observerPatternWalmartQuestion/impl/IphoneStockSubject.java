package com.vishal.observerPatternWalmartQuestion.impl;

import com.vishal.observerPatternWalmartQuestion.StockItem;
import com.vishal.observerPatternWalmartQuestion.StockObserver;
import com.vishal.observerPatternWalmartQuestion.StockSubject;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockSubject implements StockSubject {
    private List<StockObserver> observers = new ArrayList<>();
    private final StockItem item = new StockItem("Iphone", "60,000 Rs.", "White");
    private int stockCnt = 0;

    @Override
    public void register(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(item, stockCnt));
    }

    public void setStock(int newStockCnt) {
        int prevStockCnt = stockCnt;
        stockCnt = newStockCnt;

        if (prevStockCnt == 0 && stockCnt > 0)
            notifyObservers();
    }
}
