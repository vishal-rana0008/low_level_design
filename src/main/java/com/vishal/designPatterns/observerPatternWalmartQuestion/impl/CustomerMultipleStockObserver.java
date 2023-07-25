package com.vishal.designPatterns.observerPatternWalmartQuestion.impl;

import com.vishal.designPatterns.observerPatternWalmartQuestion.CustomerDetail;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockItem;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockObserver;
import com.vishal.designPatterns.observerPatternWalmartQuestion.StockSubject;

import java.util.List;

public class CustomerMultipleStockObserver implements StockObserver {
    private List<StockSubject> stockSubjects;
    private CustomerDetail customerDetail;

    public CustomerMultipleStockObserver(List<StockSubject> stockSubjects, CustomerDetail customerDetail) {
        stockSubjects.forEach(stockSubject -> stockSubject.register(this));
        this.customerDetail = customerDetail;
    }

    @Override
    public void update(StockItem stockItem, int stockCnt) {
        // emailService.sendEmail(customerDetail, stockItem, stockCnt);
        System.out.println("Email sent to : " + customerDetail + ", for item : " + stockItem);
    }

    public void stopObserving(StockSubject stockSubject) {
        int indx = stockSubjects.indexOf(stockSubject);
        stockSubjects.get(indx).remove(this);
    }
}
