package com.pluralsight;
//Start the program, first to run.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showHomeScreen();
    }

    //Show HomeScreen Method
    public static void showHomeScreen(){
        Scanner myScanner = new Scanner(System.in);

        while(true){ // While loop runs the home screen until the user choose to exit
            System.out.println("----Welcome to the DELI-cious App!----"+"\n");
            System.out.println("Choose 1 for New Order or 0 to Exit");
            int choice = myScanner.nextInt();
            //Switch case menu
            switch (choice) {
                case 1:
                    newOrder(); //Calling the new order method to create the order
                    break;
                case 0 : return; //stop the execution of the method
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    //Order Screen method
    public static void newOrder(){
        Order myOrder = new Order();//created my order object to store the list of items the user want. Need an object to call the method
        Scanner myScanner = new Scanner(System.in);

        while(true) { //While loop runs the newOrder screen until the user choose check out or cancel the order
            System.out.println("Please select one option below");
            System.out.println("Type 1 to Add Sandwich");
            System.out.println("Type 2 to add Drink ");
            System.out.println("Type 3 to Add Chips");
            System.out.println("Type 4 to check out");
            System.out.println("Type 0 to cancel the order");
            int orderChoice = myScanner.nextInt();

            switch (orderChoice){
                case 1: myOrder.addSandwich(); //adding sandwich to the myorder object that is created
                    break;
                case 2: myOrder.addDrink(); // adding drink to the myorder object that is created
                    break;
                case 3: myOrder.addChips();
                    break;
                case 4: checkOut();
                    showHomeScreen(); // calling home screen method because after user checkout go back to home screen
                    break;
                case 0:
                    System.out.println("Cancel order"); //TODO:find way to cancel order
                    showHomeScreen(); //calling the homeScreen method to take the user back to home page
                    break;
                default:
                    System.out.println("Select a Valid option");
            }
        }
    }

    private static void checkOut() {
            //TODO implement this method
       //display the order details and the price
        //Confirm - create the receipt file and go back to the home screen
        //Cancel - delete order and go back to the home screen

    }
}

//TODO: Cancel option - delete order and go back to the home screen
//TODO: BONUS
