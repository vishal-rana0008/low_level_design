package com.vishal;

import com.vishal.enums.*;
import com.vishal.model.PaymentReceipt;
import com.vishal.model.Ticket;
import com.vishal.model.Vehicle;

public class Application {

    public static void main(String [] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance(4, 4,
                120, 322, 180, 60,
                SpotStrategyType.LINEAR_STRATEGY, FairCalculationStrategyType.HOURLY_FAIR_CALCULATION_STRATEGY);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleNo("HR 26U 2231");
        vehicle1.setCustomerName("Aman");
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleNo("HR 26U 3678");
        vehicle2.setCustomerName("Ravi");
        vehicle2.setVehicleType(VehicleType.BIKE);

        Ticket ticket1 = parkingLot.enterParkingLot(vehicle1, 2, SpotType.HANDICAPPED);
        System.out.println("Ticket1 = " + ticket1);

        Thread.sleep(2000);

        Ticket ticket2 = parkingLot.enterParkingLot(vehicle2, 3, SpotType.MEDIUM);
        System.out.println("Ticket2 = " + ticket2);

        Thread.sleep(3000);

        PaymentReceipt paymentReceipt2 = parkingLot.exitParkingLot(1, ticket2, PaymentMode.CASH);
        System.out.println("Payment Receipt2 = " + paymentReceipt2);

        PaymentReceipt paymentReceipt1 = parkingLot.exitParkingLot(4, ticket1, PaymentMode.CREDIT_CARD);
        System.out.println("Payment Receipt1 = " + paymentReceipt1);
    }
}
