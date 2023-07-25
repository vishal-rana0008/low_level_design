package com.vishal.multiThreading;

public class MyThrdClassA extends Thread {

    private MyThrdClassA(String name) {
        super(name);
    }

    public static MyThrdClassA createAndStart(String name) {
        MyThrdClassA obj = new MyThrdClassA(name);
        obj.start();
        return obj;
    }

    @Override
    public void run() {
        System.out.println("New thread started : " + getName());
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("Count val : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("New thread interrupted : " + e.getMessage());
        }
        System.out.println("New thread ended : " + getName());
    }
}
