package com.pluralsight;

//Implementing the interface OrderItems

public class Drinks implements OrderItems{

    //Properties
    int size;
    String flavor;
    String brand;

    //Constructor
    public Drinks(String brand, String flavor, int size) {
        this.brand = brand;
        this.flavor = flavor;
        this.size = size;
    }

    //Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Override method from orderItems interface
    @Override
    public double getPrice() {
        return 0;
    }
}
