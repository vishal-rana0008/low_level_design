package com.vishal.parkingLot;

import com.vishal.parkingLot.enums.FairCalculationStrategyType;
import com.vishal.parkingLot.enums.PaymentMode;
import com.vishal.parkingLot.enums.SpotStrategyType;
import com.vishal.parkingLot.enums.SpotType;
import com.vishal.parkingLot.factory.EntryGatesFactory;
import com.vishal.parkingLot.factory.ExitGatesFactory;
import com.vishal.parkingLot.model.*;

import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLot;

    private List<EntryGate> entryGates;

    private List<ExitGate> exitGates;

    private ParkingLot(int noOfEntryGates, int noOfExitGates,
                       int smallSpots, int mediumSpots,
                       int largeSpots, int handicappedSpots,
                       SpotStrategyType spotStrategyType,
                       FairCalculationStrategyType fairCalculationStrategyType) {
        entryGates = EntryGatesFactory.createEntryGates(noOfEntryGates, spotStrategyType,
                smallSpots, mediumSpots, largeSpots, handicappedSpots);
        exitGates = ExitGatesFactory.createExitGates(noOfExitGates, entryGates.get(0).getSpotStrategy(),
                fairCalculationStrategyType);

    }

    public synchronized static ParkingLot getInstance(int noOfEntryGates, int noOfExitGates,
                                                      int smallSpots, int mediumSpots,
                                                      int largeSpots, int handicappedSpots,
                                                      SpotStrategyType spotStrategyType,
                                                      FairCalculationStrategyType fairCalculationStrategyType) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(noOfEntryGates, noOfExitGates, smallSpots, mediumSpots,
                    largeSpots, handicappedSpots, spotStrategyType, fairCalculationStrategyType);
        }
        return parkingLot;
    }

    public Ticket enterParkingLot(Vehicle vehicle, int entryGateNo, SpotType spotType) {
        EntryGate entryGate = entryGates.stream()
                .filter(gate -> gate.getId() == entryGateNo)
                .findFirst().orElse(null);
        return entryGate.assignTicket(vehicle, spotType);
    }

    public PaymentReceipt exitParkingLot(int exitGateNo, Ticket ticket, PaymentMode paymentMode) {
        ExitGate exitGate = exitGates.stream()
                .filter(gate -> gate.getId() == exitGateNo)
                .findFirst().orElse(null);
        return exitGate.payTicket(ticket, paymentMode);
    }
}
