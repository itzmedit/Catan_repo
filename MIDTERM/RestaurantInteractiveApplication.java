// java.util package
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

// RestaurantInteractiveApplication class
public class RestaurantInteractiveApplication {
   // displayMenu method
   static void displayMenu(String[] menu, double[] menuPrice) { // menu, menu price
      System.out.println("---> Menu <---");
      for (int x = 0; x < menu.length; x++) System.out.println("[" + (x+1) + "] " + menu[x] + " - PHP " + menuPrice[x]);
      System.out.println(); // next line
   }

   // displayAddOns method
   static void displayAddOns(String[] addOns, double[] addOnsPrice) { // add ons, add ons price
      System.out.println("---> Add Ons <---");
      for (int x = 0; x < addOns.length; x++) System.out.println("[" + (x+1) + "] " + addOns[x] + " - PHP " + addOnsPrice[x]);
      System.out.println(); // next line
   }

   // setOrder method
   static void setOrder(String[] code, double[] price, ArrayList<String> codeOrder, ArrayList<Double> priceOrder, ArrayList<Integer> qtyOrder, int index, int qty) { // code, price, code order, price order, quantity order, index, quantity
      codeOrder.add(code[index-1]); // adds in code order
      priceOrder.add(price[index-1]); // adds in price order
      qtyOrder.add(qty); // adds in quantity order
      System.out.println("\nThe order is added successfully!"); // prints when done setting
   }

   // computeTotal method
   static double computeTotal(ArrayList<Double> priceOrder, ArrayList<Integer> qtyOrder) {
      double totalAmount = 0.0; // variable for total amount
      for (int x = 0; x < priceOrder.size(); x++) totalAmount += priceOrder.get(x) * qtyOrder.get(x); // computes for total amount
      return totalAmount; // return the total amount
   }

   // orderReceipt method
   static void orderReceipt(ArrayList<String> codeOrder, ArrayList<Double>
      priceOrder, ArrayList<Integer> qtyOrder, double totalPrice) { // code order, price order, quantity order, total price
      int orderId = (int)(Math.random()*100000000); // for order ID
      System.out.println("---> Order Receipt <---");
      System.out.println("Order ID: " + orderId); // prints order ID
      
      // Prints order
      for (int x = 0; x < codeOrder.size(); x++) System.out.println("[" + (x+1) + "] " + codeOrder.get(x) + " PHP " + priceOrder.get(x) + " x" + qtyOrder.get(x));
      System.out.println("Total price: PHP " + totalPrice + " (Approximately $" + (totalPrice*0.017592) + " USD) "); // prints total price
      System.out.println("---> Thank you! <---");
   }

   // main method
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in); // Scanner class
      String[] menu = {"C1", "C2", "C3"}; // menu
      String[] addOns = {"R1", "R2"}; // add ons
      double[] menuPrice = {100.0, 150.0, 200.0}; // menu price
      double[] addOnsPrice = {35.0, 50.0}; // add ons price
      ArrayList<String> codeOrder = new ArrayList<String>(); // code order
      ArrayList<Double> priceOrder = new ArrayList<Double>(); // price order
      ArrayList<Integer> qtyOrder = new ArrayList<Integer>(); // quantity order
      double totalPrice = 0.0; // total price
      int ask1 = 1, ask2 = 1, index, qty;

      while (ask1 == 1) {
         displayMenu(menu, menuPrice); // displays menu
         System.out.print("Choose a code: "); // asks for code
         index = scan.nextInt();
         System.out.print("Quantity: "); // asks for quantity
         qty = scan.nextInt();
         setOrder(menu, menuPrice, codeOrder, priceOrder, qtyOrder, index, qty); // sets order

         // Asks user if want to add more
         System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
         ask1 = scan.nextInt();
      }

      while (ask2 == 1) {
         displayAddOns(addOns, addOnsPrice); // displays add ons
         System.out.print("Choose a code: "); // asks for code
         index = scan.nextInt();
         System.out.print("Quantity: "); // asks for quantity
         qty = scan.nextInt();
         setOrder(addOns, addOnsPrice, codeOrder, priceOrder, qtyOrder, index, qty); // sets order

         // Asks user if want to add more
         System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
         ask2 = scan.nextInt();
      }

      System.out.println("\nThe order is processing...\n");
      totalPrice = computeTotal(priceOrder, qtyOrder); // computes for total price
      orderReceipt(codeOrder, priceOrder, qtyOrder, totalPrice); // prints the order receipt
      
      scan.close();
      // exit
   }
}