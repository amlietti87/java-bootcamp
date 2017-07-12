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

// this is the builder interface.
public interface HouseBuilder {
    void buildStructure();
    void buildRoofTyoe();
    void NumberOfFloors();
    void buildOutdoorType();
    void FurnishedHouse();
    public House getHouse();
       
}
