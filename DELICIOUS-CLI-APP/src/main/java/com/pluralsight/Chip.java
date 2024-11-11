package com.pluralsight;

//Implementing the interface OrderItems
public class Chip implements OrderItems {
    //Properties
    String type;


    //Constructor
    public Chip(String type) {
        this.type = type;
    }

    //Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Override method from OrderItems interface
    @Override
    public double getPrice() {
        return 1.50; //Returning chip final price
    }

    @Override
    public String toString() {
        return "Chip{" +
                "type='" + type + '\'' +
                '}';
    }
}


//Can a method be final ?