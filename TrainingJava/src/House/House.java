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
// Class house. Here are defined the attributes and the seters of those attributes
public class House {
    private String Structure;
    private String RoofType;
    private int NumberOfFloors;
    private String OutdoorType;
    private String Furnished;

    public void setFurnished(String furnished) {
        
        this.Furnished = furnished;
        
    }

    
    public void setNumberOfFloors(int NumberOfFloors) {
        this.NumberOfFloors = NumberOfFloors;
    }

   
    public void setRoofType(String RoofType) {
        this.RoofType = RoofType;
    }

    public void setStructure(String Structure) {
        this.Structure = Structure;
    }

    public void setOutdoorType(String OutdoorType) {
        this.OutdoorType = OutdoorType;
    }
    
    

    @Override
    public String toString() {
        return"Structure: " + Structure + " RoofType: " + RoofType + " Number of Floors: " + NumberOfFloors + " Outdoor Type: " + OutdoorType + " Furnished: " + Furnished;
    }
    
    
    
}
