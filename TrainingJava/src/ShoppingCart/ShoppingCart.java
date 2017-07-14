package ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *
 * @author andreslietti
 */
public class ShoppingCart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        float total = 0;
        int sw = 0;
        PaymentMethodFactory paymentMethod = new PaymentMethodFactory();
        Cart listProducts = new Cart();
        List<Product> Shopping = new ArrayList<>();

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

        // Show all products
        listProducts.showProducts();

        // Menu 
        while (op != 0) {
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
                    sw ++;
                    System.out.println("Please Select a Product by ID");
                    op = sc.nextInt();
                    switch (op) {
                        case 1:
                            Shopping.add(p1);
                            break;
                        case 2:
                            Shopping.add(p2);
                            break;
                        case 3:
                            Shopping.add(p3);
                            break;
                        case 4:
                            Shopping.add(p4);
                            break;
                        case 5:
                            Shopping.add(p5);
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
        
        // Show the total purchase
        System.out.println("Your total purchase is");
        for (int i = 0; i < Shopping.size(); i++) {
            total += Shopping.get(i).getPrice();            
        }
        System.out.println(total);
        
        // Select the Payment Method
        System.out.println("Please Select your Payment Method");
        System.out.println("1) Credit Card " + "\n"
                         + "2) PayPal" + "\n" +
                           "3) Cash");
            op = sc.nextInt();
            
            switch (op){
                case 1:
                    PaymentMethod method = paymentMethod.getMethod("Credit Card");
                    System.out.println(method.getRequieremts());
                    break;
                case 2:
                    PaymentMethod method1 = paymentMethod.getMethod("PayPal");
                    System.out.println(method1.getRequieremts());
                    break;
                case 3:
                    PaymentMethod method2 = paymentMethod.getMethod("Cash");
                    System.out.println(method2.getRequieremts());
                    break;
                default:
                    System.out.println("The Payment Method is invalid");
                    break;
            }

    }
}
