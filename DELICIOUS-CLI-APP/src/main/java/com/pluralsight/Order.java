package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

// Class to store the content of the order
public class Order {
    //Array list to store user items choice
    private ArrayList<OrderItems> listOfItems;

    public void addSandwich(){
    }

    //Created method so I can call it depends on the user choice
    //Method to add user Drink choice.
    public void addDrink(){
Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Drink do you want?");
        System.out.println("Available Options : Water, Coca-Cola, OrangeJuice, Lemonade, WatermelonJuice");
        String drinkFlavor = myScanner.nextLine();
        System.out.println("What size do you want ? ");
        System.out.println("Available Options : Small, Medium, Large");
        String drinkSize = myScanner.nextLine();
        Drink myDrink = new Drink(drinkFlavor, drinkSize);
        listOfItems.add(myDrink); //Adding drink to list of item
    }

    //Method to add Chips to order
    public void addChips(){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Chip do you want?");
        System.out.println("Available Options : Potatoes, Tapioca, DriedVeggie");
        String chipChoice = myScanner.nextLine(); //Store user choice

        Chips myChips = new Chips(chipChoice); //Object to be added to the list of items
        listOfItems.add(myChips);
    }

    public  void checkOut(){

    }


}
