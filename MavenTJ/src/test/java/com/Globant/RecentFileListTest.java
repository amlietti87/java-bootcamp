/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Globant;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andreslietti
 */
public class RecentFileListTest {
    
    private RecentFileList<String> rflist;
    
    @Before
    public void setUp(){
        rflist = new RecentFileList<String>();
    }
    
    @Test
    public void sizeInitialList(){
        assertEquals(0, rflist.size());
    }
    
    @Test
    public void sizeAddOneElement(){
        rflist.add("a");
        assertEquals(1, rflist.size());
        assertEquals("a", rflist.get(0));
    }
    
    @Test
    public void getOneElement(){
        givenAListContaining("a");
        String result = rflist.get(0);
        assertEquals("a", result);
    }

    @Test
    public void sizeAddSecondElement(){
        givenAListContaining("a","b","c");
        assertEquals(2, rflist.size());
    }
    
    @Test
    public void getTwoElements(){
        givenAListContaining("c","b");
        String result = rflist.get(0);
        assertEquals("c", result);
    }

    private void givenAListContaining(String... elements) {
        for (String s : elements){
            System.out.println(s);
            rflist.add(s);
        }
    }
    
    @Test 
    public void removeLastElement(){
        int lastElement = rflist.size() - 1;
        givenAListContaining("a","b");
        rflist.removeLast(lastElement);
        assertEquals(1, rflist.size());
        assertEquals("a", rflist.get(0));
        
    }
    
    @Test
    public void findElement(){
        
    }
    
}
