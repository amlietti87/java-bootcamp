/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author andreslietti
 */
public class ShoppingCart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner pr1 = new Scanner(System.in);
        int op = 1;
        float total = 0;
        int sw = 0;
        PaymentMethodFactory paymentMethod = new PaymentMethodFactory();
        Cart listProducts = new Cart();
        Cart Offers = new Cart();
        List<Product> Shopping = new ArrayList<>();
        ContextTypePayment contextTP = new ContextTypePayment(new CounterTypePayment());

        //Product Load.
        Product p1 = new Product("Book", (float) 37.5, 3);
        Product p2 = new Product("Pen", (float) 0.5, 10);
        Product p3 = new Product("Computer", (float) 500.0, 8);
        Product p4 = new Product("Mouse", (float) 40.0, 4);
        Product p5 = new Product("Case", (float) 23.5, 9);

        listProducts.addProducts(p1);
        listProducts.addProducts(p2);
        listProducts.addProducts(p3);
        listProducts.addProducts(p4);
        listProducts.addProducts(p5);


        // Offers Products Load.
        Product p6 = new Product("PS4", (float) 150.0, 3);
        Product p7 = new Product("Tv 4K", (float) 300.0, 10);
        Product p8 = new Product("IPod", (float) 100.0, 8);
        Product p9 = new Product("Backpack", (float) 40.0, 4);
        Product p10 = new Product("FIFA 17 PS4", (float) 25.5, 9);

        Offers.addProducts(p6);
        Offers.addProducts(p7);
        Offers.addProducts(p8);
        Offers.addProducts(p9);
        Offers.addProducts(p10);

        while (op != 0) {
            // Show all products
            System.out.println("Pruducts");
            listProducts.showProducts();

            // Show all products in offer
            System.out.println("Amazon Prime Day Offers: ");
            Offers.showProducts();

            // Menu
            System.out.println("Menu:");
            System.out.println("0) Exit " + "\n"
                    + "1) Buy Products");
            op = sc.nextInt();

            switch (op) {
                case 0:
                    if (sw == 0) {
                        System.out.println("Good Bye");
                        System.exit(0);
                    } else {
                        System.out.println("Thanks for your purchase");
                        op = 0;
                        break;
                    }

                case 1:
                    sw++;
                    System.out.println("Please Select a Product by Name");
                    String pr = pr1.nextLine();
                    switch (pr) {
                        case "Book":
                            Shopping.add(p1);
                            break;
                        case "Pen":
                            Shopping.add(p2);
                            break;
                        case "Computer":
                            Shopping.add(p3);
                            break;
                        case "Mouse":
                            Shopping.add(p4);
                            break;
                        case "Case":
                            Shopping.add(p5);
                            break;
                        case "PS4":
                            Shopping.add(p6);
                            break;
                        case "Tv 4K":
                            Shopping.add(p7);
                            break;
                        case "Ipod":
                            Shopping.add(p8);
                            break;
                        case "BackPack":
                            Shopping.add(p9);
                            break;
                        case "FIFA 17 PS4":
                            Shopping.add(p10);
                            break;
                        default:

                            break;

                    }
                    break;
            }
        }

        // Show the purchase
        System.out.println("Your purchase is");
        for (int i = 0; i < Shopping.size(); i++) {
            System.out.println("Product: " + Shopping.get(i).getName() + "\n" + "Price: " + Shopping.get(i).getPrice());
        }

        //Show the total of purchase without discount.
        for (int i = 0; i < Shopping.size(); i++) {
            total += Shopping.get(i).getPrice();
        }

        // Select the Payment Method
        System.out.println("Please Select your Payment Method");
        System.out.println("1) Credit Card " + "\n"
                + "2) PayPal" + "\n"
                + "3) Cash");
        op = sc.nextInt();

        switch (op) {
            case 1:
                PaymentMethod method = paymentMethod.getMethod("Credit Card");
                contextTP.executeStrategy("Credit Card");
                System.out.println("You have a 10% in your total purchase!");
                System.out.println("Your total purchase now is");
                System.out.println(method.getDiscount(Shopping));
                System.out.println(method.getRequieremts());
                break;
            case 2:
                PaymentMethod method1 = paymentMethod.getMethod("PayPal");
                contextTP.executeStrategy("PayPal");
                System.out.println("The cheapest item in your purchase is free!!");
                System.out.println("Your total purchase now is");
                System.out.println(method1.getDiscount(Shopping));
                System.out.println(method1.getRequieremts());
                break;
            case 3:
                PaymentMethod method2 = paymentMethod.getMethod("Cash");
                contextTP.executeStrategy("Cash");
                System.out.println("You have a 90% in your most expensive item!");
                System.out.println("Your total purchase now is");
                System.out.println(method2.getDiscount(Shopping));
                System.out.println(method2.getRequieremts());
                break;
            default:
                System.out.println("The Payment Method is invalid");
                break;
        }

        //Show all payment methods.
        for (int i = 0; i < contextTP.executeStrategy(" ").size(); i++) {
            System.out.println("Payment Method: " + contextTP.executeStrategy(" ").get(i));

        }

    }

}

