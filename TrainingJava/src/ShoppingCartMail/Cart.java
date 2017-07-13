/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartMail;

// @author andreslietti

import java.util.ArrayList;
import java.util.List;


// Class Cart, this class contains all available products.
public class Cart {
    List<Product> listProducts;

    public Cart(){
        listProducts = new ArrayList<>();
    }
    public void addProducts (Product product){
        listProducts.add(product);
    }

    public void showProducts(){
        for (int i = 0; i < listProducts.size(); i++) {
            System.out.println("ID Product: " + (i + 1) + ", " + "Name: " + listProducts.get(i).getName() + ", " + "Price: " + listProducts.get(i).getPrice());

        }
    }

}
