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
        System.out.println("----Welcome to the DELI-cious App!----"+"\n");
        System.out.println("Choose 1 for New Order or 0 to Exit");
        int choice = myScanner.nextInt();
//Switch case menu
        switch (choice) {
            case 1: //TODO: call a method to create an order
                newOrder();
                break;
            case 0 : return;
            default:
                System.out.println("Invalid Choice");
//TODO: find a way to loop home screen to go back to home screen
        }
    }

    //Order Screen method
    public static void newOrder(){
        Order myOrder = new Order();//created my order object to store the list of items the user want. Need an object to call the method
        Scanner myScanner = new Scanner(System.in);
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
            case 4: myOrder.checkOut();
            break;
            case 0: myOrder = null;
                showHomeScreen(); //calling the homeScreen method to take the user back to home page
                break;
            default:
                System.out.println("Select a Valid option");

        }

    }

}
