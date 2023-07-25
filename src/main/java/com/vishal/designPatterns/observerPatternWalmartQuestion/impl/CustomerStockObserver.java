package com.vishal.designPatterns.observerPatternWalmartQuestion.impl;

import com.vishal.designPatterns.observerPatternWalmartQuestion.CustomerDetail;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockItem;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockObserver;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockSubject;

public class CustomerStockObserver implements StockObserver {
    private CustomerDetail customerDetail;
    private StockSubject stockSubject;

    public CustomerStockObserver(CustomerDetail customerDetail, StockSubject stockSubject) {
        this.customerDetail = customerDetail;
        this.stockSubject = stockSubject;
        stockSubject.register(this);
    }

    @Override
    public void update(StockItem stockItem, int stockCnt) {
        // emailService.sendEmail(customerDetail, stockItem, stockCnt);
        System.out.println("Email sent to : " + customerDetail + ", for item : " + stockItem);
    }
}
