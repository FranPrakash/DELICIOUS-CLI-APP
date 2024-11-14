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
    //Calculate drink price
    @Override
    public double getPrice() {
        if(size.equalsIgnoreCase("Small")) return 2.00; //Ignore case method upper case and lower case are accepted as user input
        else if(size.equalsIgnoreCase("Medium")) return 2.50;
        else if (size.equalsIgnoreCase("Large")) return 3.00;
        else return 0;
    }

    @Override
    public String toString() { // Medium Coca-Cola: $2
      return size + " " + flavor + " " + "$" + getPrice();
    }
}
//Size and favor price