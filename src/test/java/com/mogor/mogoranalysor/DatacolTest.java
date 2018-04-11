/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MrVhek,IQBrod, Skullhack
 */
public class DatacolTest {
    private Datacol subject;
    
    @Before
    public void setup() throws Exception {
        subject = new Datacol("colTest", Arrays.asList("bonjour","F"));
    }
    
    @Test
    public void testLabel() {
        assertEquals("colTest", subject.getLabel().toString());
    }
}
