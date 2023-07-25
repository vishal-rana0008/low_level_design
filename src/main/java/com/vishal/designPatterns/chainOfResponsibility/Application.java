package com.vishal.designPatterns.chainOfResponsibility;

public class Application {
    public static void main(String[] args) {
        System.out.println("Money Store before : " + MoneyStore.getDenominationMap().toString());

        Chain responsibilityChain = new twoThousandProcessor(new fiveHundredProcessor(new hundredProcessor(null)));
        if (!responsibilityChain.processRequest(400)) {
            System.out.println("Sorry the request could not be processed");
        }

        System.out.println("Money Store after : " + MoneyStore.getDenominationMap().toString());
    }
}
