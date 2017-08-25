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
class SoundexCode {
    
    
    public String soundex(String name) {
        
        char[] x = name.toUpperCase().toCharArray();
        char firstLetter = x[0];
        
        // converts letters to numeric.
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    x[i] = '1';
                    break;

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    x[i] = '2';
                    break;

                case 'D':
                case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M':
                case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                default:
                    x[i] = '0';
                    break;
            }

        }

        String output = "" + firstLetter;
        
        // remove duplicates numbers.
        for (int i = 1; i < x.length; i++) {
            if (x[i] != x[i-1] && x[i] != '0') {
                // two letters with the same number separated by 'H' or 'W' are coded as a single number.
                if (i + 2 < x.length) {
                    if (x[i] == x[i + 2]){
                        x [i + 2] = '0';
                        
                    }
                }
                  output += x[i];
            }      
        }
        output = output + "0000";
        return output.substring(0, 4);

    }

}
