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
                System.out.println("New order Selected");
                break;
            case 0 : return;
            default:
                System.out.println("Invalid Choice");

        }
    }



}
