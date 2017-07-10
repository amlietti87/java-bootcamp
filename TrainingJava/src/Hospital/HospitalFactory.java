/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author andreslietti This class contains the method to create the Hospital.
 */
public class HospitalFactory {

    public Hospital getHospital(String sector) {
        Hospital hospital = null;

        switch (sector) {
            case "Laboratory":
                hospital = new Laboratory();
                break;

            case "Offices":
                hospital = new Offices();
                break;

            case "Ultrasound":
                hospital = new Ultrasound();
                break;

            case "ImagingDiagnostic":
                hospital = new ImagingDiagnostic();
                break;

            case "Internment":
                hospital = new Internment();
                break;

            case "Therapy":
                hospital = new Therapy();
                break;

            case "Maternity":
                hospital = new Maternity();
                break;

        }

        return hospital;

    }
}
