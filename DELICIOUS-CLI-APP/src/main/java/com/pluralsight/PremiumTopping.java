package com.pluralsight;

import java.util.List;

//Child of topping
public class PremiumTopping extends Topping {

    //Super Constructor
    public PremiumTopping(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    //calculating the topping and the extra topping value
    @Override
    public double getPrice() {
        List<String> meats = List.of("steak", "ham", "salami", "roast beef", "chicken", "bacon"); //List to store meats toppings
        List<String> cheeses = List.of("american", "provolone", "cheddar", "swiss"); //List to store Cheeses toppings
        String type = ""; // store meat or cheese

        //Checks if the topping is meat or cheese
        if (meats.contains(getName().toLowerCase())) //TO lower case to make sure it is not case-sensitive
            type = "meat"; // We search for the name of the topping in the list of meats. If we find it then type=meat else type=cheese
        else type = "cheese";

       //getting the price of the topping based on the sandwich size, meat or cheese, or if is extra.
        if (type.equalsIgnoreCase("meat") && !isExtra() && getSandwichSize() == 4) return 1.00;  // meat topping (no extra) for 4 inch sandwich price is $1.00
        else if (type.equalsIgnoreCase("meat") && !isExtra() && getSandwichSize() == 8) return 2.00;
        else if (type.equalsIgnoreCase("meat") && !isExtra() && getSandwichSize() == 12) return 3.00;
        else if (type.equalsIgnoreCase("meat") && isExtra() && getSandwichSize() == 4) return 0.50;
        else if (type.equalsIgnoreCase("meat") && isExtra() && getSandwichSize() == 8) return 1.00;  // meat topping (extra) for 8 inch sandwich price is $1.00
        else if (type.equalsIgnoreCase("meat") && isExtra() && getSandwichSize() == 12) return 1.50;
        else if (type.equalsIgnoreCase("cheese") && !isExtra() && getSandwichSize() == 4) return 0.75;
        else if (type.equalsIgnoreCase("cheese") && !isExtra() && getSandwichSize() == 8) return 1.50;
        else if (type.equalsIgnoreCase("cheese") && !isExtra() && getSandwichSize() == 12) return 2.25;
        else if (type.equalsIgnoreCase("cheese") && isExtra() && getSandwichSize() == 4) return 0.30;
        else if (type.equalsIgnoreCase("cheese") && isExtra() && getSandwichSize() == 8) return 0.60;
        else if (type.equalsIgnoreCase("cheese") && isExtra() && getSandwichSize() == 12) return 0.90; // cheese topping (extra) for 12 inch sandwich price is $0.90
        else return 0; //Default
    }

    //osmig help
    @Override
    public String toString() {
        if (isExtra()) return "Extra " + this.getName() + ": $" + this.getPrice();
        else return this.getName() + ": $" + this.getPrice();
    }
}


/* premium Cheese and meat
American
Provolone
Cheddar
Swiss
 */





