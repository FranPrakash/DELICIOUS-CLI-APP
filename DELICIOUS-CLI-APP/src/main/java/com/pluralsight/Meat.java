package com.pluralsight;

//Child of topping
public class Meat extends Topping {

    private String name;

    //Super Constructor
    public Meat(String name, double price) {
        super(name, price);
    }
}
