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
public class HouseDirector {
    
    private HouseBuilder houseBuilder = null;

	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

        public HouseDirector() {
            
        }

	public void constructHouse() {
		houseBuilder.buildStructure();
		houseBuilder.buildRoofTyoe();
                houseBuilder.NumberOfFloors();
                houseBuilder.buildOutdoorType();
                houseBuilder.FurnishedHouse();
	}

	public House getHouse() {
		return houseBuilder.getHouse();
	}
    
}
