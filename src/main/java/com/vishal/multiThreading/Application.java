package com.vishal.multiThreading;

public class Application {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("Running thread 1"));
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running thread 2");
            }
        });

        thread1.start();
        thread2.start();

        MyThrdClass obj = MyThrdClass.createAndStart("Thread 1");

        MyThrdClassA obj2 = MyThrdClassA.createAndStart("Thread 4");


        Calculator cal = new CalculatorImpl();
        System.out.println(cal.sum(2,6));

        Calculator cal1 = (x, y) -> x+y;
        System.out.println(cal1.sum(2, 6));

    }
}
