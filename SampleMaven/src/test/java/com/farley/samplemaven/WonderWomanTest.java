/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farley.samplemaven;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amy
 */
public class WonderWomanTest {
    
    public WonderWomanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSpecialPowers method, of class WonderWoman.
     */
    @org.junit.Test
    public void testGetSpecialPowers() {
        System.out.println("getSpecialPowers");
        WonderWoman instance = new WonderWoman();
        ArrayList expResult = null;
        ArrayList result = instance.getSpecialPowers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
