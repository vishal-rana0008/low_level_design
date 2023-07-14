package com.vishal.observerPatternWalmartQuestion.impl;

import com.vishal.observerPatternWalmartQuestion.CustomerDetail;
import com.vishal.observerPatternWalmartQuestion.StockItem;
import com.vishal.observerPatternWalmartQuestion.StockObserver;
import com.vishal.observerPatternWalmartQuestion.StockSubject;

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
