package com.interview.interview2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Employee {
    private final static Map<Integer, Employee> employeeMap;

    static {
        employeeMap = new HashMap<>();
    }

    public Employee(Map<Integer, Employee> employeeMap) {
//        this.employeeMap = employeeMap;
    }

    public static Map<Integer, Employee> getEmployeeMap() {

        Thread t = new Thread() {
            public void foo() {
                System.out.println("inside anonymous foo");
            }

            @Override
            public void start() {
                System.out.println("inside anonymous run");
                foo();
            }
        };

        t.start();

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(2, 4);
        mp.put(1, 9);

        return Collections.unmodifiableMap(employeeMap);
    }

    public static void main(String[] args) {
        getEmployeeMap();
    }
}
