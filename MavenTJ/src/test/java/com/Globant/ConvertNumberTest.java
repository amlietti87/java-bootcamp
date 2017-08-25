/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author andreslietti
 */
@RunWith (Parameterized.class)
public class ConvertNumberTest {
    
    private ConvertNumber cn = new ConvertNumber();
    private int integerNumber;
    private String romanNumber;
    
    public ConvertNumberTest(String roman, int integer){
        integerNumber = integer;
        romanNumber = roman;
    }
    
    @Parameters
    public static List <Object[]> data(){
        return Arrays.asList(new Object [][] {
            {"I",1},
            {"V",5},
            {"X",10},
            {"XV",15},
            {"CC",200},
            {"IV",4},
            {"XC",90},
            {"MMDCCCXCVI", 2896},
            {"",0},
            {"MMMCMXCIX", 3999},
        
        });
    }  
    
    @Test
    public void convertToRoman(){
        assertEquals(romanNumber,cn.toRoman(integerNumber) );
    }
    
    @Test
    public void convertToInteger(){
        assertEquals(integerNumber, cn.toInteger(romanNumber) );
    }
   
}
