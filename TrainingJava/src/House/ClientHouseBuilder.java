
package House;

import java.util.Scanner;


 //@author andreslietti
 

// In this class the house is created requesting data from a client. 
public class ClientHouseBuilder implements HouseBuilder {
    private House house;
    
    
    public ClientHouseBuilder(){
        house = new House();
    }
    
    @Override
    public void buildStructure() {
        System.out.println("Choose a structure: ");
        Scanner scan = new Scanner (System.in); 
        String choice = scan.nextLine (); 
        house.setStructure(choice);
    }

    @Override
    public void buildRoofTyoe() {
        System.out.println("Choose type of roof: ");
        Scanner scan = new Scanner (System.in); 
        String choice = scan.nextLine (); 
        house.setRoofType(choice);
    }

    @Override
    public void NumberOfFloors() {
        System.out.println("Choose Number of Floors: ");
        Scanner scan = new Scanner (System.in); 
        int choice = scan.nextInt(); 
        house.setNumberOfFloors(choice);
    }

    @Override
    public void buildOutdoorType() {
        System.out.println("Choose a type of Outdoors: ");
        Scanner scan = new Scanner (System.in); 
        String choice = scan.nextLine (); 
        house.setOutdoorType(choice);
    }

    @Override
    public void FurnishedHouse() {
        System.out.println("Do you want furnished? ");
        Scanner scan = new Scanner (System.in); 
        String choice = scan.nextLine (); 
        if ("yes".equals(choice)) {
            house.setFurnished("Furnished");
        }
            house.setFurnished("Not Furnished");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
    
}
