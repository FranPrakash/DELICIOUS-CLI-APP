package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

// Class to store the content of the order
public class Order {
    //Array list to store user items choice
    public static ArrayList<OrderItems> listOfItems;

    public Order() {
        listOfItems = new ArrayList<OrderItems>();
    }

    //Created method so I can call it depends on the user choice
    //Method to add userSandwich choice to the order.
    public void addSandwich() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Bread do you want?");
        System.out.println("Available Options : white, wheat, rye, wrap");
        String breadType = myScanner.nextLine();
        System.out.println("What Sandwich size do you want ? ");
        System.out.println("Available Options : 4\", 8\", 12\"");
        int sandwichSize = myScanner.nextInt();
        myScanner.nextLine();
        System.out.println("Do you want the Sandwich toasted? Type Y for Yes and N for no");
        String toastedChoice = myScanner.nextLine();
        boolean isToasted; //Using and if to convert from Y and N to true and false.Started by initiating the value to false
        if (toastedChoice.equals("Y")) {
            isToasted = true;
        } else {
            isToasted = false;
        }
        System.out.println("What side do you want?");
        System.out.println("Available Options: Au Jus, Sauce");
        String sideChoice = myScanner.nextLine();
        Sandwich mySandwich = new Sandwich(breadType, isToasted, sideChoice, sandwichSize);

        // TODO: Add toppings to the sandwich
        // mySandwich.addTopping();

        listOfItems.add(mySandwich);
    }

    //Created method so I can call it depends on the user choice
    //Method to add user Drink choice.
    public void addDrink() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Drink do you want?");
        System.out.println("Available Options : Water, Coca-Cola, OrangeJuice, Lemonade, WatermelonJuice");
        String drinkFlavor = myScanner.nextLine();
        System.out.println("What size do you want ? ");
        System.out.println("Available Options : Small, Medium, Large");
        String drinkSize = myScanner.nextLine();
        Drink myDrink = new Drink(drinkFlavor, drinkSize); //Creating a drink object to add to listOfItems
        listOfItems.add(myDrink); //Adding drink to list of item
    }

    //Method to add Chip to order
    public void addChips() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Chip do you want?");
        System.out.println("Available Options : Potatoes, Tapioca, DriedVeggie");
        String chipChoice = myScanner.nextLine(); //Store user choice

        Chip myChip = new Chip(chipChoice); //Object to be added to the list of items
        listOfItems.add(myChip); //adding chips to list of items
    }

    public void checkOut() {
        System.out.println(getOrderDetails()); //printing the order details by calling the method show order details
        Scanner myScanner = new Scanner(System.in); //get the user input
        System.out.println("Please type C to confirm the order or X to Cancel the Order");
        String userChoice = myScanner.nextLine();
        if (userChoice.equals("C")) {
            confirmOrder(); //call the method confirmOrder to confirm the order which will print the receipt
        } else {
            listOfItems = null; //Making the list of items null
            System.out.println("Order has been canceled");
        }
        //display the order details and the price
        //Cancel - delete order and go back to the home screen
    }


   //Method Confirm - create the receipt file and go back to the home screen //Osmig help
    public static void confirmOrder(){
        String date = String.valueOf(LocalDate.now());
        String time = String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)); // hhmmssml -> hhmmss (took away mlsecs)
        // default format  yyyy-MM-dddd
        System.out.println(date);
        System.out.println(time);

        date = date.replace("-", ""); // take - away
        time = time.replace(":", ""); // take : away
        // Capstone format  yyyyMMdddd
        System.out.println(date);
        // Capstone format  HHMMSS
        System.out.println(time);
        // yyyyMMdddd-HHMMSS.txt
        System.out.println(date + "-" + time + ".txt");
        String file = date + "-" + time + ".txt";// combining the way the capstone asked
       try {
           BufferedWriter bw = new BufferedWriter(new FileWriter("Receipt.csv")); // path where to write the file and file name

           bw.write(file); // instead of writing the file name, pass in the receipt format
           bw.close(); // needs to close after done
       } catch (Exception e) {
           System.out.println("An error occurred");
           e.printStackTrace(); //Display error
       }
    }


    //This methods will have list of all items
    private String getOrderDetails() {
        //TODO: implement this method
        return "";
    }


    //Osmig
    @Override
    public String toString() {
        return "Order{" + listOfItems.toString() + "}";
    }
}


//TODO: Create a method called confirm order to print the order receipt and go back to home screen
//TODO:Create a method to display the total cost of the order.
//TODO: When the customer completes the order, the order details should be saved to a
// receipts folder. Each order should have it's own receipt file, and it should be
// named by the date and time that the order was placed