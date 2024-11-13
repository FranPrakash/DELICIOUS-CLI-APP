package com.pluralsight;
//Child of Topping

public class PremiumTopping extends Topping {

    private String toppingType;
    //Super Constructor

    public PremiumTopping(boolean isExtra, String name, int sandwichSize, String toppingType) {
        super(isExtra, name, sandwichSize);
        this.toppingType = toppingType;
    }

    @Override
    public double getPrice(){
        return (0.75 * this.getSandwichSize()/4);
    }

    //osmig help
    @Override
    public String toString() {
        return "";
    }
}
