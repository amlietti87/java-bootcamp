/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author andreslietti
 * Here the Hospital is created.
 */
public class HospitalFactoryPatternDemo {
    
    public static void main(String[] args) {
        
        HospitalFactory hospitalFactory = new HospitalFactory();
        
        Hospital sector1 = hospitalFactory.getHospital("Laboratory");
        Hospital sector2 = hospitalFactory.getHospital("Offices");
        Hospital sector3 = hospitalFactory.getHospital("Ultrasound");
        Hospital sector4 = hospitalFactory.getHospital("ImagingDiagnostic");
        Hospital sector5 = hospitalFactory.getHospital("Internment");
        Hospital sector6 = hospitalFactory.getHospital("Therapy");
        Hospital sector7 = hospitalFactory.getHospital("Maternity");
        
        System.out.println("The different areas inside the Hospital are: " + sector1.getSector() + ", " + sector2.getSector() + ", " + sector3.getSector() + ", " + sector4.getSector()
                           + ", " + sector5.getSector() + ", " + sector6.getSector() + " and " + sector7.getSector());
        
    }
    
}
