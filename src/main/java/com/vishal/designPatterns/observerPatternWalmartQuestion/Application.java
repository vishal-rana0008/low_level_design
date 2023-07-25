package com.vishal.designPatterns.observerPatternWalmartQuestion;

import com.vishal.designPatterns.observerPatternWalmartQuestion.impl.*;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
//        IphoneStockSubject iphoneStockSubject = new IphoneStockSubject();
//
//        StockObserver customerRahul = new CustomerStockObserver(
//                new CustomerDetail("Rahul", "rahul@gmail.com", "7825679467"),
//                iphoneStockSubject);
//
//        StockObserver customerShyam = new CustomerStockObserver(
//                new CustomerDetail("Shyam", "shyam@gmail.com", "2398574626"),
//                iphoneStockSubject);
//
//        iphoneStockSubject.setStock(30);
//        iphoneStockSubject.setStock(0);
//        iphoneStockSubject.setStock(10);


        System.out.println("*********************************");
        System.out.println("");

        IphoneStockSubject iphoneStockSubject1 = new IphoneStockSubject();
        WashingMachineStockSubject washingMachineStockSubject = new WashingMachineStockSubject();
        LaptopStockSubject laptopStockSubject = new LaptopStockSubject();

        StockObserver rahul = new CustomerMultipleStockObserver(Arrays.asList(laptopStockSubject, washingMachineStockSubject),
                new CustomerDetail("Rahul", "rahul@gmail.com", "7825679467"));

        StockObserver shyam = new CustomerMultipleStockObserver(Arrays.asList(iphoneStockSubject1, washingMachineStockSubject),
                new CustomerDetail("Shyam", "shyam@gmail.com", "2398574626"));

        iphoneStockSubject1.setStock(30);
        washingMachineStockSubject.setStock(5);

    }
}
