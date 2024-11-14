package com.pluralsight;

//Parent class
public abstract class Topping {

    //Properties
    private String name;
    private boolean isExtra;
    private int sandwichSize;

    //Constructor
    public Topping(boolean isExtra, String name, int sandwichSize) {
        this.isExtra = isExtra;
        this.name = name;
        this.sandwichSize = sandwichSize;
    }

    //Getters and setters
    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public abstract double getPrice();

    @Override
    public abstract String toString();
}

