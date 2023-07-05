package com.vishal.parkingLot.factory;

import com.vishal.parkingLot.enums.FairCalculationStrategyType;
import com.vishal.parkingLot.model.ExitGate;
import com.vishal.parkingLot.model.strategy.SpotStrategy;
import com.vishal.parkingLot.model.strategy.impl.CustomFairCalculationStrategy;
import com.vishal.parkingLot.model.strategy.impl.HourlyFairCalculationStrategy;

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
