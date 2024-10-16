package com.example.miageGR1.data;

public class Car {

    String plateNumber;
    int price;
    boolean rented;

    public Car(String plateNumber, int price) {
        this.plateNumber = plateNumber;
        this.price = price;
        this.rented = false;
    }

    public Car() {
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
