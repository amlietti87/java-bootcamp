/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

import java.util.Scanner;

/**
 *
 * @author andreslietti
 */

// In this class the house is created requesting data from a client. 
public class ClientHouseBuilder implements HouseBuilder {
    private House house;
    
    
    public ClientHouseBuilder(){
        house = new House();
    }
    
    @Override
    public void buildStructure() {
        System.out.println("Choose a structure: ");
        String choice;
        Scanner scan = new Scanner (System.in); 
        choice = scan.nextLine (); 
        house.setStructure(choice);
    }

    @Override
    public void buildRoofTyoe() {
        System.out.println("Choose type of roof: ");
        String choice;
        Scanner scan = new Scanner (System.in);
       choice = scan.nextLine (); 
        house.setRoofType(choice);
    }

    @Override
    public void NumberOfFloors() {
        System.out.println("Choose Number of Floors: ");
        int choice;
        Scanner scan = new Scanner (System.in); 
        choice = scan.nextInt(); 
        house.setNumberOfFloors(choice);
    }

    @Override
    public void buildOutdoorType() {
        System.out.println("Choose a type of Outdoors: ");
        String choice;
        Scanner scan = new Scanner (System.in); 
        choice = scan.nextLine (); 
        house.setOutdoorType(choice);
    }

    @Override
    public void FurnishedHouse() {
        System.out.println("Do you want furnished? ");
        String choice;
        Scanner scan = new Scanner (System.in); 
        choice = scan.nextLine (); 
        if (choice.contains("yes")) {
            house.setFurnished("Furnished");
        }
            house.setFurnished("Not Furnished");
    }

    @Override
    public House getHouse() {
        return house;
    }
    
}
