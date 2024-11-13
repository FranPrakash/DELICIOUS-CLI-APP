package com.pluralsight;
//Child of Topping

public class RegularTopping extends Topping {  // includes regular toppings and sauces

    //Super Constructor
    public RegularTopping(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    @Override
    public double getPrice(){
        return 0;
    }

    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }
}