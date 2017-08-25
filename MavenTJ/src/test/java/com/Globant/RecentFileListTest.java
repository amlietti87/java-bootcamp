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
    private int listLong;
    
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
        rflist.addFirst("a",listLong);
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
        givenAListContaining("a","b");
        assertEquals(2, rflist.size());
    }
    
    @Test
    public void addMoreThanMaxLong(){
        givenAListContaining("a","b","c","d","e","f");
        assertEquals(5, rflist.size());
    }
    
    @Test
    public void addSameFile(){
        givenAListContaining("a","g","h","a","u");
        assertEquals(4, rflist.size());
        assertEquals("a", rflist.get(1));
    }
    
    @Test
    public void getTwoElements(){
        givenAListContaining("b","c");
        String result = rflist.get(1);
        assertEquals("b", result);
    }

    private void givenAListContaining(String... elements) {
        listLong = 0;
        for (String s : elements){
            listLong ++;
            rflist.addFirst(s,listLong);
        }
    }
    
    @Test 
    public void removeLastElement(){
        givenAListContaining("a","b");
        rflist.removeLast();
        assertEquals(1, rflist.size());
        assertEquals("b", rflist.get(0));
        
    }
    
    @Test
    public void findElement(){
        givenAListContaining("a","b");
        rflist.existFile("c");
        assertEquals(false, rflist.existFile("c"));
        
    }
    
    @Test
    public void sort(){
        givenAListContaining("a","b");
        rflist.deleteFile("a");
        assertEquals(1, rflist.size());
    }
    
}
