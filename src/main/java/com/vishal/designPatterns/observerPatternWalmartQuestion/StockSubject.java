package com.vishal.designPatterns.observerPatternWalmartQuestion;

public interface StockSubject {
    void register(StockObserver observer);
    void remove(StockObserver observer);
    void notifyObservers();
}
