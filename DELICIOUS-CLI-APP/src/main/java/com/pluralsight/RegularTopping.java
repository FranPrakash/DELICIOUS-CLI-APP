package com.pluralsight;
//Child of Topping

public class RegularTopping extends Topping {  // includes regular toppings and sauces

    //Super Constructor
    public RegularTopping(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    //Calculate price based on the size and extra topping
    @Override
    public double getPrice(){
        return 0; //Return zero because the price is 0
        }

        @Override
        public String toString () {
            return this.getName() + " $" + this.getPrice();
        }
    }

/*Regular toppings
Lettuce
Peppers
Onions
Tomatoes
Jalapeños
Cucumbers
Pickles
Guacamole
Mushrooms
Sauces (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette)
Sides (au jus, sauce) */