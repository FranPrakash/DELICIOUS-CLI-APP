package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//implementing the interface OrderItems
public class Sandwich implements OrderItems {

    //Properties
    private String breadType;
    private int size;
    private String side;
    private boolean isToasted;

    //Store all the toppings added to sandwich. I can add to this list objects that of it children classes (Premium and regular toppings)
    private ArrayList<Topping> sandwichToppings;

    //Constructor
    public Sandwich(String breadType, boolean isToasted, String side, int size) {
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.sandwichToppings = new ArrayList<Topping>(); //Initializing Sand.Topping as an empty list
        this.side = side;
        this.size = size;
    }

    //Topping Menu method. User enter user choice method called in the order class
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

    // Add Topping Menu Method
    //Check if user choose premium or regular toppings . if user choose premium topping the method add premium topping is called else regular topping method is called
    public void addTopping(String userChoice) {
        //List to store meats and cheese premium toppings
        List<String> premiumToppings = List.of("steak", "ham", "salami", "roast beef", "chicken", "bacon", "american", "provolone", "cheddar", "swiss");
        List<String> regularToppings = List.of("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms", "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"); //List to store Cheeses toppings

        if (premiumToppings.contains(userChoice))
            addPremiumTopping(userChoice);  //if it is there call method add premium topping
        else addRegularTopping(userChoice);
    }

    //Method to add regular toppings to the sandwich // method called in the Add topping method
    private void addRegularTopping(String userChoice) {
        Scanner myScanner = new Scanner(System.in);
        //Creating an object from the regular topping class
        RegularTopping myRT = new RegularTopping(false, userChoice, size);
        // adding the topping object to the sandwich topping list because the list store object toppings
        sandwichToppings.add(myRT);
        //Asking user for extra regular toppings
        System.out.println("Do you want extra " + userChoice + " Type Y for yes and N for no");
        if (myScanner.nextLine().equals("Y")) {
            RegularTopping myExtraRT = new RegularTopping(true, userChoice, size);

            //Add myExtraRT object to the Sandwich topping list
            sandwichToppings.add(myExtraRT);
        }
    }

    //Method to add Premium topping to the sandwich
    private void addPremiumTopping(String userChoice) {
        Scanner myScanner = new Scanner(System.in);
        //Creating an object from the premium topping class
        PremiumTopping myPT = new PremiumTopping(false, userChoice, size);
        //adding the extra topping object to the sandwich topping list
        sandwichToppings.add(myPT);
        //Asking user for premium regular toppings
        System.out.println("Do you want extra " + userChoice + " ? Type Y for yes and N for no");
        if (myScanner.nextLine().equals("Y")) {
            PremiumTopping myExtraPT = new PremiumTopping(true, userChoice, size);

            //Add myExtraPT object to the Sandwich topping list
            sandwichToppings.add(myExtraPT);
        }
    }

    // Calculate the total Price of the Sandwich
    @Override
    public double getPrice() {
        // calculate the price of the bread
        double breadPrice = 0; //create variable to store price of the bread
        if (size == 4) breadPrice = 5.50;
        else if (size == 8) breadPrice = 7.00;
        else breadPrice = 8.50;

        //Store the total price of the sandwich toppings
        double toppingsPriceSum = 0;

        //add the price of each topping to the toppingsPriceSum
        for (Topping myTopping : sandwichToppings) { // loop through the toppings
            toppingsPriceSum += myTopping.getPrice(); // add the price of each topping to the toppingsPriceSum
        }
        return breadPrice + toppingsPriceSum; // return the total price that is the sum of bread and toppings
    }

    //Format the order details return a string
    @Override
    public String toString() {
        String myText = size + " Inch";//Storing the size in the variable myText
        if (isToasted) myText += " Toasted"; //Adding the word "toasted" to myText if isToasted is true
        myText += " " + breadType + " Sandwich with " + side + " Side" + ": $" + getPrice(); //Adding the rest of the text we want to display on the receipt

        //For loop to display the extra topping to the receipt
        for (Topping myTopping : sandwichToppings) {
            myText += "\n -" + myTopping;
        }
        return myText;
    }
}
//Size + breadType + toasted and side
