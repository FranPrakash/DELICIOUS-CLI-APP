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

    //Getters and setters
    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public ArrayList<Topping> getSandwichToppings() {
        return sandwichToppings;
    }

    public void setSandwichToppings(ArrayList<Topping> sandwichToppings) {
        this.sandwichToppings = sandwichToppings;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Override method from orderItems interface
    @Override
    public double getPrice() {
        return 0;
        //TODO: implement this method
    }

    // Menu add topping
    public void addTopping() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("What type of toppings do you prefer ? Please choose from below options: ");
        System.out.println("Meats: steak , ham, salami, roast beef, chicken , bacon (4\": $1, 8\": $2, 12\": $3)");
        System.out.println("Extra meat: (4\": $0.50, 8\": $1.00, 12\": $1.50)");
        System.out.println("Cheese: American,Provolone, Cheddar, Swiss (4\": $0.75, 8\": $1.50, 12\": $2.25)");
        System.out.println("Extra Cheese: (4\": $0.30, 8\": $0.60, 12\": $0.90)");
        System.out.println("Regular Toppings: Lettuce, Peppers, Onions, Tomatoes, Jalapenos, Cucumbers, Pickles, Guacamole, Mushrooms (Included)");
        System.out.println("Sauces: Mayo, Mustard, Ketchup, Ranch, Thousand Islands , Vinaigrette (included)");
        String userChoice = myScanner.nextLine();
        switch (userChoice) {
            case "steak", "ham", "salami", "roast beef", "chicken",
                 "bacon": // I am checking for multiple values in a single case. User can choose any of the options
                break;
            case "American", "Provolone", "Cheddar", "Swiss":
                Cheese myChesse = new Cheese(false, userChoice, size); //Creating an object from the cheese class and adding it to the sandwich topping list
                sandwichToppings.add(myChesse); // adding the cheese object to the sandwich topping list because the list store object toppings
                System.out.println("Do you want extra Cheese ? Type Y for yes and N for no");
                if (myScanner.nextLine().equals("Y")) {
                    Cheese myExtraChesse = new Cheese(true, userChoice, size); //Parameters True because is true for extra cheese, userChoice type of cheese and size is the size of the bread
                    sandwichToppings.add(myChesse);
                }
                break;
            case "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole",
                 "Mushrooms":
                break;
            case "Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette":
            default:
                System.out.println("Invalid Option");

        }
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", size=" + size +
                ", side='" + side + '\'' +
                ", isToasted=" + isToasted +
                ", sandwichToppings=" + sandwichToppings +
                '}';
    }
}
