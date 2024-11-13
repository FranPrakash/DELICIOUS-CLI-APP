package com.pluralsight;
//Child of Topping

public class Cheese extends Topping {

    //Super Constructor
    public Cheese(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    @Override
    public double getPrice(){
        if(isExtra()) return (0.30 * this.getSandwichSize()/4);
        else return (0.75 * this.getSandwichSize()/4);
    }

    //osmig help
    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }
}

// TODO: Copy this class and modify it to create the Meat class, Sauce class and the RegularToppings class
// TODO: change the prices in the getPrice() method appropriately. Sauce and Regular Toppings will have zero price.
