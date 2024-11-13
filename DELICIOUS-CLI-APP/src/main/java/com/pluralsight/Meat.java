package com.pluralsight;

//Premium topping
//Child of Topping
public class Meat extends Topping {

    //Super Constructor
    public Meat(boolean isExtra, String name, int sandwichSize) {
        super(isExtra, name, sandwichSize);
    }

    //Calculate the extra meat
    @Override
    public double getPrice() {
        switch (getSandwichSize()) {
            case 4: //Size of the sandwich
                if (isExtra()) return 0.50;
                else return 1.00;
            case 8:
                if (isExtra()) return 1.00;
                else return 2.00;
            case 12:
                if (isExtra()) return 1.50;
                else return 3.00;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.getName() + " $" + this.getPrice();
    }
}

  /*
        if(isExtra()) return (0.50 * this.getSandwichSize()/4);
        else return (1.00 * this.getSandwichSize()/4);
        */

/* premium topping
Steak
Ham
Salami
Roast Beef
Chicken
Bacon
 */