package com.vishal.designPatterns.chainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public class MoneyStore {
    private static Map<Integer, Integer> denominationMap;

    static {
        denominationMap = new HashMap<>();
        denominationMap.put(2000, 0);
        denominationMap.put(500, 5);
        denominationMap.put(100, 12);
    }

    public static Map<Integer, Integer> getDenominationMap() {
        return denominationMap;
    }
}
