package com.vishal.carRentalSystem.model;

public class User {
    private int userId;
    private String name;
    private String contact;
    private String licenceNo;
    private Address address;
    private double accountBalance;

    public User(int userId, String name, String contact, String licenceNo, Address address, double accountBalance) {
        this.userId = userId;
        this.name = name;
        this.contact = contact;
        this.licenceNo = licenceNo;
        this.address = address;
        this.accountBalance = accountBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void reduceAccountBalance(double reduceAmt) {
        this.accountBalance -= reduceAmt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", licenceNo='" + licenceNo + '\'' +
                ", address=" + address +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
