package com.vishal.observerPatternWalmartQuestion;

public interface StockObserver {
    void update(StockItem stockItem, int stockCnt);
}
