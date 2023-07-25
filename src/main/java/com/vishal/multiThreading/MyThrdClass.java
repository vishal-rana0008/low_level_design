package com.vishal.multiThreading;

public class MyThrdClass implements Runnable {
    private Thread t;

    private MyThrdClass(String name) {
        t = new Thread(this, name);
    }

    public static MyThrdClass createAndStart(String name) {
        MyThrdClass obj = new MyThrdClass(name);
        obj.t.start();
        return obj;
    }

    @Override
    public void run() {
        System.out.println("thread created : " + t.getName());
    }
}
