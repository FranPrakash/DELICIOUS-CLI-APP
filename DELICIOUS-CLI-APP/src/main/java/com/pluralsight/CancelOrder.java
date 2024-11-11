package com.pluralsight;
import java.util.List;

public class CancelOrder {

    //Osmig help
 public static void cancel(List<Order> costumerOrder){
     costumerOrder.clear();
     System.out.println(costumerOrder);
     Main.showHomeScreen();
 }

}
