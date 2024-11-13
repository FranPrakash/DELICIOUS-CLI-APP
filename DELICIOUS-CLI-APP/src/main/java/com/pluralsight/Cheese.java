package com.pluralsight;
//Child of Topping

public class Cheese extends Topping {

    //Super Constructor
    public Cheese(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    //Switch case to check the extra price of the premium toppings
    @Override
    public double getPrice() {
        switch (getSandwichSize()) {
            case 4: //Sandwich size
                if (isExtra()) return 0.30;
                else return 0.00;
            case 8:
                if (isExtra()) return 0.60;
                else return 0.00;
            case 12:
                if (isExtra()) return 0.90;
                else return 0.00;
        }
        return 0;
    }

    //osmig help
    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }
}


// TODO: Copy this class and modify it to create the Meat class, Sauce class and the RegularToppings class
// TODO: change the prices in the getPrice() method appropriately. Sauce and Regular Toppings will have zero price.


/* premium Cheese
American
Provolone
Cheddar
Swiss
 */