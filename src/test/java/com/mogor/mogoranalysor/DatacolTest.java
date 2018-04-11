/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import java.util.Arrays;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author MrVhek,IQBrod, Skullhack
 */
public class DatacolTest {
    private Datacol subject;

    /**  TEST CONSTRUCTEUR  **/
    @Test
    public void testConstructor() throws Exception {
        
    }
    
    /**  TEST METHODES  **/
    @Test
    public void testLabelString() {
        try {
            subject = new Datacol("colTest", Arrays.asList("bonjour", "F"));
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown.");
        }
        assertEquals("colTest", subject.getLabel().toString());
    }
    
    @Test
    public void testListString() {
        try {
            subject = new Datacol("colTest", Arrays.asList("bonjour", "F"));
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown.");
        }
        assertEquals("bonjour", subject.getListObject().get(0).toString());
        assertEquals("F", subject.getListObject().get(1).toString());
    }
    
    @Test
    public void testLabelInt() {
        try {
            subject = new Datacol(2, Arrays.asList("bonjour", "F"));
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown.");
        }
        assertEquals(2, (int)subject.getLabel());
    }
    
    @Test
    public void testListInt() {
        try {
            subject = new Datacol("colTest", Arrays.asList(2, 8));
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown.");
        }
        assertEquals(2, (int)subject.getListObject().get(0));
        assertEquals(8, (int)subject.getListObject().get(1));
    }
}
