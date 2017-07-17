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
    
    private int size;
    private double totalsell;
    List<Product> listProducts;
    List<Product> listOffers;
    

    public Cart() {
        listProducts = new ArrayList<>();
        listOffers = new ArrayList<>();
    }

    public void addProducts(Product newproduct) {
        if (listProducts.contains(newproduct)) {
            int pos = listProducts.indexOf(newproduct);
            Product oldProduct = listProducts.get(pos);
            oldProduct.setQuantity(oldProduct.getQuantity() + newproduct.getQuantity());
        }
        listProducts.add(newproduct);
    }

    public void addOffers(Product newoffers) {
        if (listOffers.contains(newoffers)) {
            int pos = listOffers.indexOf(newoffers);
            Product oldOffer = listOffers.get(pos);
            oldOffer.setQuantity(oldOffer.getQuantity() + newoffers.getQuantity());
        }
        listOffers.add(newoffers);
    }

    public void showProducts() {
        for (int i = 0; i < listProducts.size(); i++) {
            System.out.println("ID Product: " + (i + 1) + ", " + "Name: " + listProducts.get(i).getName() + ", " + "Price: " + listProducts.get(i).getPrice());

        }
    }

    public void showOffers() {
        for (int i = 0; i < listOffers.size(); i++) {
            System.out.println("ID Product: " + (i + 1) + ", " + "Name: " + listOffers.get(i).getName() + ", " + "Price: " + listOffers.get(i).getPrice());

        }
    }

    public double getTotal(List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            totalsell += products.get(i).getPrice();
        }
        return totalsell;
    }

    public void updateProductPrice(Product newProductPrice) {
        if (listProducts.contains(newProductPrice)) {
            int pos = listProducts.indexOf(newProductPrice);
            Product oldProduct = listProducts.get(pos);
            oldProduct.setPrice(newProductPrice.getPrice());
        }

    }
    
    public int size() {
        
        for (int i = 0; i < listProducts.size(); i++) {
            size += (i + 1);   
        }
        return size;
    }

}


