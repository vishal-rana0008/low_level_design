package com.vishal.factory;

import com.vishal.enums.FairCalculationStrategyType;
import com.vishal.enums.PaymentStrategyType;
import com.vishal.model.ExitGate;
import com.vishal.model.strategy.FairCalculationStrategy;
import com.vishal.model.strategy.SpotStrategy;
import com.vishal.model.strategy.impl.CashPayment;
import com.vishal.model.strategy.impl.CreditCardPayment;
import com.vishal.model.strategy.impl.CustomFairCalculationStrategy;
import com.vishal.model.strategy.impl.HourlyFairCalculationStrategy;

import java.util.ArrayList;
import java.util.List;

public class ExitGatesFactory {

    public static List<ExitGate> createExitGates(int noOfExitGates, SpotStrategy spotStrategy,
                                                 FairCalculationStrategyType fairCalculationStrategyType) {
        HourlyFairCalculationStrategy hourlyFairCalculationStrategy = new HourlyFairCalculationStrategy();
        CustomFairCalculationStrategy customFairCalculationStrategy = new CustomFairCalculationStrategy();

        List<ExitGate> exitGates = new ArrayList<>();

        for (int i = 1; i <= noOfExitGates; i++){
            switch (fairCalculationStrategyType) {
                case HOURLY_FAIR_CALCULATION_STRATEGY:
                    exitGates.add(new ExitGate(i, spotStrategy, hourlyFairCalculationStrategy));
                    break;
                case CUSTOM_FAIR_CALCULATION_STRATEGY:
                    exitGates.add(new ExitGate(i, spotStrategy, customFairCalculationStrategy));
                    break;
            }
        }

        return exitGates;
    }
}
