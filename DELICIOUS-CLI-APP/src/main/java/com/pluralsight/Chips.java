package com.pluralsight;

//Implementing the interface OrderItems
public class Chips implements OrderItems {
    //Properties
    String type;
    String brand;

    //Constructor
    public Chips(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    //Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Override method from OrderItems interface
    @Override
    public double getPrice() {
        return 0;
    }
}
