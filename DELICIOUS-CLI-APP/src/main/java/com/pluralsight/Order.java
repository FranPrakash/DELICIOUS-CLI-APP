package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

//Class to store the content of the order

public class Order {
    //Array list to store user items choice. OrderItem is an interface that sandwich, chips and drinks implements, so I can Store object of those classes in a single list and I don't need top have 3 different list.
   private static ArrayList<OrderItems> listOfItems; // Creating a variable of type array list of order items interface. <> type. It accepts object of classes that implemts the interface
//this array list can store objects of class sandwich chips and drinks because the classes that implement the interface

   //Constructor
    public Order() {
        listOfItems = new ArrayList<OrderItems>(); //initializing the array list in the constructor
    }

    //Created method so I can call it depends on the user choice
    //Method to ask the user what type of sandwich he wants, based on the user input I create a sandwich object than add the sandwich object to the list of item
    public void addSandwich() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Bread do you want?");
        System.out.println("Available Options : White, Wheat, Rye, Wrap");
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

        listOfItems.add(mySandwich);//Adding sandwich to list of item
    }

    //Created method so I can call it depends on the user choice
    //Method to ask the user what type of drink he wants, based on the user input I create a drink object than add the drink object to the list of item
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

    //Method to ask the user what type of chip he wants, based on the user input I create a chip object than add the chip object to the list of item
    public void addChips() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of Chip do you want?");
        System.out.println("Available Options : Potatoes, Tapioca, DriedVeggie");
        String chipChoice = myScanner.nextLine(); //Store user choice

        Chip myChip = new Chip(chipChoice); //Object to be added to the list of items
        listOfItems.add(myChip); //adding chips to list of items
    }
    //Method to ask the user if he wants to confirm or cancel the order, if user chose to confirm the printReceipt method is called else user has chosen to cancel the order
    public void checkOut() {
        System.out.println(getOrderDetails()); //printing the order details by calling the method show order details
        Scanner myScanner = new Scanner(System.in); //get the user input
        System.out.println("Please type C to confirm the order or X to Cancel the Order");
        String userChoice = myScanner.nextLine();
        if (userChoice.equals("C")) {
            printReceipt(); //call the method printReceipt to confirm the order which will print the receipt if user confirm the order
        } else {
            listOfItems = null; //Making the list of items empty
            System.out.println("Order has been canceled");
        }
    }

    //Osmig help
   //Method Confirm - create the receipt file and go back to the home screen
    public static void printReceipt(){
        String date = String.valueOf(LocalDate.now()); //Get current date format YYYY-MM-DD
        String time = String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)); //Get current time  hhmmssml -> hhmmss (took away mlsecs)

        date = date.replace("-", ""); // take away the dash -
        time = time.replace(":", ""); // take away the colons :
        // Capstone format  yyyyMMdddd-hhmmss.txt

        String fileName = date + "-" + time + ".txt";// combining the way the capstone asked to create the file name
       try {
           BufferedWriter myBw = new BufferedWriter(new FileWriter("receipts/"+ fileName)); // fileName is the name of the file inside eof the folder receipts
            // receipts/yyyyMMdddd-hhmmss.txt //Filewriter specify the file im writing to.
           myBw.write(getOrderDetails()); // write to the file calling the order details method that returns order info
           myBw.close(); // needs to close after done
       } catch (Exception e) {
           System.out.println("An error occurred");
           e.printStackTrace(); //Display error
       }
    }

    //This method will return the list of items and their prices and total order amount
    //For each loop to loop in the list of items to get the items details one by one
    public static String getOrderDetails() {
        String orderDetails ="---Order Details---\n";
        for(OrderItems item: listOfItems){ // for each item in list of items (order items type of array list)
            orderDetails += item +"\n"; //adding item to the orderDetails variable
        }
        orderDetails += "Order Total: $" + getOrderTotal();
        return orderDetails;
    }

    private static double getOrderTotal() {
        return 0;
        //TODO: implement this method
    }


    //Osmig
    @Override
    public String toString() {
        return "Order{" + listOfItems.toString() + "}";
    }

}



//TODO:Create a method to display the total cost of the order.
//TODO: When the customer completes the order, the order details should be saved to a
// receipts folder. Each order should have it's own receipt file, and it should be
// named by the date and time that the order was placed