package com.example;
import org.junit.*;
import static org.junit.Assert.*;
public class CalculatorTest{
 private Calculator c;
 @Before public void setUp(){c=new Calculator();}
 @After public void tearDown(){c=null;}
 @Test public void testAdd(){assertEquals(5,c.add(2,3));}
 @Test public void testSub(){assertEquals(2,c.subtract(5,3));}
 @Test public void testMul(){assertTrue(c.multiply(2,3)==6);}
 @Test(expected=IllegalArgumentException.class)
 public void testDivZero(){c.divide(5,0);}
 @Test public void testAssertions(){
  assertFalse(2>3);
  assertNull(null);
  assertNotNull(new Object());
 }
}
