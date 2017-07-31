/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import org.junit.Test;

/**
 *
 * @author andreslietti
 */
public class SoundexCodeTest {
    
    private SoundexCode sc = new SoundexCode();
    private String name; 
    private String code;
    
    
    @Test
    
    public void convertNamesToInt(){
        
        name = "Rupert";
        code = sc.soundex(name);
        System.out.println(code);
        
        name = "Robert";
        code = sc.soundex(name);
        System.out.println(code);
        
        name = "Rubin";
        code = sc.soundex(name);
        System.out.println(code);
        
        name = "Ashcraft";
        code = sc.soundex(name);
        System.out.println(code);
        
        name = "Tymczak";
        code = sc.soundex(name);
        System.out.println(code);
        
        name = "Pfister";
        code = sc.soundex(name);
        System.out.println(code);
        
        
    }
    
}
