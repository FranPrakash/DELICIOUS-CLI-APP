package com.pluralsight;
//Start the program, first to run.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showHomeScreen();
    }

    //Show HomeScreen Method
    public static void showHomeScreen() {
        Scanner myScanner = new Scanner(System.in);

        while (true) { // While loop runs the home screen until the user choose to exit
            System.out.println("----Welcome to the DELI-cious App!----" + "\n");
            System.out.println("Choose 1 for New Order or 0 to Exit");
            int choice = myScanner.nextInt();
            //Switch case menu
            switch (choice) {
                case 1:
                    showOrderScreen(); //Calling the new order method to create the order
                    break;
                case 0:
                    return; //stop the execution of the method
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    //OderScreen method to get user input to add sandwich drinks, checkout etc
    //New order method created here because cant create an object of class inside the same class
    public static void showOrderScreen() {
        Order myOrder = new Order();//created my order object to store the list of items the user want in the order class array list.  Need an object to call the method
        Scanner myScanner = new Scanner(System.in);

        while (true) { //While loop runs the newOrder screen until the user choose check out or cancel the order
            System.out.println("Please select one option below:" + "\n");
            System.out.println("Type 1 to Add Sandwich");
            System.out.println("Type 2 to add Drink ");
            System.out.println("Type 3 to Add Chips");
            System.out.println("Type 4 to check out");
            System.out.println("Type 0 to cancel the order");
            int orderChoice = myScanner.nextInt();

            switch (orderChoice) {
                case 1:
                    myOrder.addSandwich(); //When user choose option 1 I will use myorder object to call teh add sandwich method that is created in the order class
                    break;
                case 2:
                    myOrder.addDrink(); //When user choose option 2 I will use myorder object to call teh add drink method that is created in the order class
                    break;
                case 3:
                    myOrder.addChips();
                    break;
                case 4:
                    myOrder.checkOut(); //When user choose option 4 I will use myorder object to call teh add checkout method that is created in the order class
                    showHomeScreen(); // calling home screen method because after user checkout go back to home screen
                    break;
                case 0:
                    myOrder = null; //Making my order object blank
                    System.out.println("Your order has been canceled");
                    showHomeScreen(); //calling the homeScreen method to take the user back to home page
                    break;
                default:
                    System.out.println("Your options is not valid, try again :)");
            }
        }
    }


}

//TODO: OOP
//TODO: demonstrate Encapsulation : string need to be private and getter and setter and constructor public (so I can access and modify the fields)
//TODO: demonstrate Abstraction need to create interface. (need to have abstraction)
//TODO: demonstrate inheritance (inherit properties and behavior of an existing class ) Have a parent class and children override
//TODO: demostrate Polymorphism : method overloading and Override (is one enough ? ) (method overloading same method name with different parameters).


