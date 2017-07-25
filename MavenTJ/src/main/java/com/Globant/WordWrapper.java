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
class WordWrapper {

    static String wrap(String sentence, int columns) {
        if (sentence.length() <= columns) {
            return sentence;
        } else {
            String firstLine = sentence.substring(0, columns);
            int space = firstLine.indexOf(' '); 
            if (space != -1){
                int breackPoint = space;
                int startAt = space + 1;
                return sentence.substring(0, breackPoint) + "\n" + wrap(sentence.substring(startAt), columns);
            }
            if (sentence.charAt(columns - 1) == ' ') {
                
               return sentence.substring(0, columns - 1) + "\n" + wrap(sentence.substring(columns),columns); 
            }
            if (sentence.charAt(columns) == ' ') {
                
                return sentence.substring(0, columns) + "\n" + wrap(sentence.substring(columns + 1),columns); 
            }
            
            return sentence.substring(0, columns) + "\n" + wrap(sentence.substring(columns),columns);
        }
        
    }
    
}
