package com.pluralsight;
//Child of Topping

public class Cheese extends Topping {

    private String name;

    //Constructor
    public Cheese(String name) {
        this.name = name;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //osmig help
    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
