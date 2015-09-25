/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farley;

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
public class FizzBuzzTest {
    
    public FizzBuzzTest() {
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
     * Test of doFizzBuzz method, of class FizzBuzz.
     */
    @Test
    public void testDoFizzBuzz() throws Exception {
        System.out.println("doFizzBuzz");
        int start = 1000;
        int end = 5000;
        FizzBuzz instance = new FizzBuzz();
        boolean expResult = false;
        boolean result = instance.doFizzBuzz(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
