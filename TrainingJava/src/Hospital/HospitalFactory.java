/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author andreslietti
 * This class contains the method to create the Hospital.   
 */
public class HospitalFactory {
    
    public Hospital getHospital (String sector){
            if (sector == null) {
                return null;
            }
            if (sector.equalsIgnoreCase("Laboratory")) {
                return new Laboratory();
            } else if (sector.equalsIgnoreCase("Offices")) {
                return new Offices();
            } else if (sector.equalsIgnoreCase("Ultrasound")) {
                return new Ultrasound();
            } else if (sector.equalsIgnoreCase("ImagingDiagnostic")) {
                return new ImagingDiagnostic();
            } else if (sector.equalsIgnoreCase("Internment")) {
                return new Internment();
            } else if (sector.equalsIgnoreCase("Therapy")) {
                return new Therapy();
            } else if (sector.equalsIgnoreCase("Maternity")) {
                return new Maternity();
            }
        
        return null;
    
    }
}    
