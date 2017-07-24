/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import org.junit.*;

/**
 *
 * @author andreslietti
 */
public class NumbersToWordTest {
    
    
    
     
     @Test
     public void convert(){
         NumbersToWord ntw = new NumbersToWord();
         ntw.convertLessThanOneThousand(2);
         ntw.takeipart(134.5);         
         ntw.takefpart(352.67);
         System.err.println(ntw.convert(2523.78));
         
         
     }
    
}
