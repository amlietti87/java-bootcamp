/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author andreslietti
 */
public class WordWrapperTest {
    
    @Test
    public void wrapWord(){
        
        assertEquals("Hello this is a test from wrap word program", WordWrapper.wrap("Hello this is a test from wrap word program",60));
        assertEquals("Excel\nent", WordWrapper.wrap("Excelent", 5));
        assertEquals("Hello\nWord!", WordWrapper.wrap("Hello Word!", 7));
        assertEquals("ab\ncd\nef", WordWrapper.wrap("ab cd ef", 3));
        
    }
    
       
            
}
