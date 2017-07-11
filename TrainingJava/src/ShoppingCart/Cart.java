package ShoppingCart;

import java.util.ArrayList;
import java.util.List;


 
// @author andreslietti
 
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
            System.out.println("ID Product: " + (i + 1) + "\n" + "Name: " + listProducts.get(i).getName() + "\n" + "Price: " + listProducts.get(i).getPrice() + "\n" + "Quintity: " + listProducts.get(i).getQuantity() );
            
        }
    }
    
}
