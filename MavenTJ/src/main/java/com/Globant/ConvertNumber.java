/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

/**
 *
 * @author andreslietti
 */
class ConvertNumber {
    
    private static final String[] romanParts = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    private static final int[] intParts = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    
    
   
    
    public static String toRoman(int integerNumber) {
        if (integerNumber <1 || integerNumber > 3999) {
            return "";
        }
        int m = romanParts.length;
        String ret = "";
        while (--m >= 0) { 
            while (integerNumber >= intParts[m]) {
                integerNumber -= intParts[m];
                ret += romanParts[m];                   
            }
            
        }
        return ret;
    }

    public static int toInteger(String romanNumber) {
        int m = romanParts.length-1;
        int ret = 0;
        int pos = 0;
        while (pos<romanNumber.length() && m>=0) {
            if (romanNumber.charAt(pos) == romanParts[m].charAt(0) && 
                    (!isDoubleLettered(m) || 
                    (pos < romanNumber.length()-1 && romanNumber.charAt(pos+1)==romanParts[m].charAt(1)))) {
                ret += intParts[m];
                pos += romanParts[m].length() ;
            } 
            else 
                m--;
            
            
        }
        return ret;
    }

    private static boolean isDoubleLettered(int m) {
        return (m&1) > 0;
    }
    
}
