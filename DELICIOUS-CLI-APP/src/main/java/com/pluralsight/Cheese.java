package com.pluralsight;
//Child of Topping

public class Cheese extends Topping {


    //Super Constructor

    public Cheese(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    @Override
    public double getPrice(){
        return (0.75 * this.getSandwichSize()/4);
    }

    //osmig help
    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }
}
