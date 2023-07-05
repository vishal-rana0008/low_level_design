package com.vishal.parkingLot.model;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private int inTime;
    private Spot allottedSpot;
    private int entryGateNo;

    public Ticket() {
        id = (int) (Math.random() * 100);
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getInTime() {
        return inTime;
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public Spot getAllottedSpot() {
        return allottedSpot;
    }

    public void setAllottedSpot(Spot allottedSpot) {
        this.allottedSpot = allottedSpot;
    }

    public int getEntryGateNo() {
        return entryGateNo;
    }

    public void setEntryGateNo(int entryGateNo) {
        this.entryGateNo = entryGateNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", inTime=" + inTime +
                ", allottedSpot=" + allottedSpot +
                ", entryGateNo=" + entryGateNo +
                '}';
    }
}
