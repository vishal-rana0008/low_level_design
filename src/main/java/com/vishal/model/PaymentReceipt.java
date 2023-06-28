package com.vishal.model;

public class PaymentReceipt {
    private String transactionId;
    private Vehicle vehicle;
    private int inTime;
    private int outTime;
    private double fair;
    private int entryGateNo;
    private int exitGateNo;

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setInTime(int inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public void setEntryGateNo(int entryGate) {
        this.entryGateNo = entryGate;
    }

    public void setExitGateNo(int exitGate) {
        this.exitGateNo = exitGate;
    }

    @Override
    public String toString() {
        return "PaymentReceipt{" +
                "transactionId='" + transactionId + '\'' +
                ", vehicle=" + vehicle +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", fair=" + fair +
                ", entryGateNo=" + entryGateNo +
                ", exitGateNo=" + exitGateNo +
                '}';
    }
}
