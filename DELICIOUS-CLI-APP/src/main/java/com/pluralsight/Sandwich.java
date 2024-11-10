package com.pluralsight;

import java.util.ArrayList;
//implementing the interface OrderItems
public class Sandwich implements OrderItems {

    //Properties
    private String breadType;
    private int size;
    private String sauces;
    boolean isToasted;
    //arraylist<Topping>

    //Override method from orderItems interface
    @Override
    public double getPrice() {
        return 0;
    }

    public void addTopping(){

    }

}
