package com.pluralsight;

import java.util.ArrayList;
//implementing the interface OrderItems
public class Sandwich implements OrderItems {

    //Properties
    private String breadType;
    private int size;
    private String side;
    private boolean isToasted;
    private ArrayList<Topping> sandwichToppings; //Array list to store toppings

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

    public void addTopping(){
        //TODO: Implement this method
       // TODO: User choose extra topping
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
