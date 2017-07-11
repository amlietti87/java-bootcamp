    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartDiscount;

/**
 *
 * @author andreslietti
 */
   // Class Product with attributes and constructors.
 public class Product {
     
     private String name;
     private float price;
     private int quantity;
 
     public Product(String name, float price, int quiantity){
         this.name = name;
         this.price = price;
         this.quantity = quiantity;
     }
     
     public String getName() {
         return name;
     }
 
     public float getPrice() {
         return price;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public void setPrice(float price) {
         this.price = price;
     }
 
     public void setQuantity(int quantity) {
         this.quantity = quantity;
     }
 
     public int getQuantity() {
         return quantity;
     }
   
     
     
     
 }
    

