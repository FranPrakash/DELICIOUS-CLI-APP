package com.pluralsight;

//Implementing the interface OrderItems

public class Drink implements OrderItems{

    //Properties
    private String size;
    private String flavor;


    //Constructor
    public Drink(String flavor,  String  size) {
        this.flavor = flavor;
        this.size = size;
    }

    //Getters and Setters
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public  String  getSize() {
        return size;
    }

    public void setSize( String  size) {
        this.size = size;
    }

    //Override method from orderItems interface
    @Override
    public double getPrice() {
        return 0;
        //TODO implement this method
    }

    @Override
    public String toString() { // Medium Coca-Cola: $2
      return size + " " + flavor + " " + "$" + getPrice();
    }
}
//Size and favor price