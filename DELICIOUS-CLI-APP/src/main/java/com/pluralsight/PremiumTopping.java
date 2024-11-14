package com.pluralsight;


public class PremiumTopping extends Topping {

    //Super Constructor
    public PremiumTopping(boolean isExtra, String name, int sandwichSize) {
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
        return this.getName() + ": $" + this.getPrice();
    }
}





/* premium Cheese
American
Provolone
Cheddar
Swiss
 */





