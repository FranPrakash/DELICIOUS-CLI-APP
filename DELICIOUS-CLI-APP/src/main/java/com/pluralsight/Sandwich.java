package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

//implementing the interface OrderItems
public class Sandwich implements OrderItems {

    //Properties
    private String breadType;
    private int size;
    private String side;
    private boolean isToasted;

    //Array list to store topping objects/ (store information about the topping)
    //Creating an array list of topping objects so that I can add to this list objects that represents different types of toppings like cheese, sauce and meat.
    private ArrayList<Topping> sandwichToppings; //I can store objects from the children classes

    //Constructor
    public Sandwich(String breadType, boolean isToasted, String side, int size) {
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.sandwichToppings = new ArrayList<Topping>(); //Initializing Sand.Topping as an empty list
        this.side = side;
        this.size = size;
    }

    //Override method from orderItems interface
    @Override
    public double getPrice() { // Calculate the total Price of the Sandwich
        // calculate the price of the bread
        double breadPrice = 0;
        if (size == 4) breadPrice = 5.50;
        else if (size == 8) breadPrice = 7.00;
        else breadPrice = 8.50;

        //calculate the sum of prices of the toppings in the sandwich
        double toppingsPriceSum = 0;
        // for each myTopping object of Type Topping in sandwichToppings list
        for (Topping myTopping : sandwichToppings) { // loop through the toppings
            toppingsPriceSum += myTopping.getPrice(); // add the price of each topping to the toppingsPriceSum
        }

        return breadPrice + toppingsPriceSum; // total price = bread price + toppings price

    }

    // Add Topping Menu
    public void addTopping() {
        Scanner myScanner = new Scanner(System.in);

        //showToppingMenu(); //Calling the show topping menu helper method
        System.out.println("Enter your choice...");
        String userChoice = myScanner.nextLine().toLowerCase();
        switch (userChoice) {
            case "steak", "ham", "salami", "roast beef", "chicken",
                 "bacon": // I am checking for multiple values in a single case. User can choose any of the options
            case "american", "provolone", "cheddar", "swiss":
                PremiumTopping myPT = new PremiumTopping(false, userChoice, size); //Creating an object from the cheese class and adding it to the sandwich topping list
                sandwichToppings.add(myPT); // adding the extra topping object to the sandwich topping list because the list store object toppings
                System.out.println("Do you want extra " + userChoice + " ? Type Y for yes and N for no");
                if (myScanner.nextLine().equals("Y")) {
                    PremiumTopping myExtraPT = new PremiumTopping(true, userChoice, size); //Parameters True because is true for extra cheese, userChoice type of cheese and size is the size of the bread
                    sandwichToppings.add(myExtraPT);
                }
                break;
            case "lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole",
                 "mushrooms":
            case "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette":
                RegularTopping myRT = new RegularTopping(false, userChoice, size); //Creating an object from the cheese class and adding it to the sandwich topping list
                sandwichToppings.add(myRT); // adding the topping object to the sandwich topping list because the list store object toppings
                System.out.println("Do you want extra " + userChoice + " ? Type Y for yes and N for no");
                if (myScanner.nextLine().equals("Y")) {
                    RegularTopping myExtraRT = new RegularTopping(true, userChoice, size); //Parameters True because is true for extra cheese, userChoice type of cheese and size is the size of the bread
                    sandwichToppings.add(myExtraRT);
                }
                break;
            default:
                System.out.println("Invalid Option");
        }
    }

    //Topping Menu method
    public static void showToppingMenu() {
        System.out.println("What type of toppings do you want ?");
        System.out.println("Regular Toppings: Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms   (Included)");
        System.out.println("Sauces: Mayo, Mustard, Ketchup, Ranch, Thousand Islands , Vinaigrette                                       (included)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Meats: Steak , Ham, Salami, Roast Beef, Chicken , Bacon                            (Price: 4\": $1, 8\": $2, 12\": $3)");
        System.out.println("Extra meat                                                                 (Price: 4\": $0.50, 8\": $1.00, 12\": $1.50)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Cheese: American,Provolone, Cheddar, Swiss                                     (Price 4\": $0.75, 8\": $1.50, 12\": $2.25)");
        System.out.println("Extra Cheese                                                              (Price : 4\": $0.30, 8\": $0.60, 12\": $0.90)");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
    }

    //Format the order details return a string
    @Override
    public String toString() {
        String myText = size + " Inch";   //  storing the size in the variable myText
        if (isToasted) myText += " Toasted"; // adding the word "toasted" to myText if isToasted is true
        myText += " " + breadType + " Sandwich with " + side + " Side" + ": $" + getPrice(); // Adding the rest of the text we want to display on the receipt

        //???????
        for(Topping myTopping: sandwichToppings) {
            myText += "\n -" + myTopping;
        }
          return myText;
    }
}


//Size + breadType + toasted and side
