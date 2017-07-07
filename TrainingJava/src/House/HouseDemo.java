/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package House;

/**
 *
 * @author andreslietti
 */

// Main.
public class HouseDemo {
    
    public static void main(String[] args) {

		HouseBuilder houseBuilder = new ClientHouseBuilder();
		HouseDirector houseDirector = new HouseDirector(houseBuilder);
		houseDirector.constructHouse();
		House house = houseDirector.getHouse();
		System.out.println("The House is: " + house);
		
	}
    
}
