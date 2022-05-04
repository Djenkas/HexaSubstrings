package org.eigorje.task;

import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;

public class HexaSubstringsTests {

    HexaSubstrings hexa;

    @Test
    public void testFindSubstring1() {
        Assert.assertTrue(hexa.findSubstrings("aa22bb33f").equals("a2 b33"));
    }

    @Test
    public void testFindSubstring2() {
        Assert.assertTrue(hexa.findSubstrings("a01").equals("a0 a01"));
    }

    @Test
    public void testFindSubstring3() {
        Assert.assertTrue(hexa.findSubstrings("7961686f6f").equals("f6 f6"));
    }


    @Test   // 500 char string
    public void testValidSubstringsLong() {
        String base ="abcde12345";
        String repeatedBase = new String(new char[50]).replace("\0",base);
        hexa.findSubstrings(repeatedBase);
        Assert.assertTrue(true);
    }

    @Test  // 5000 char string
    public void testValidSubstringsLonger() {
        String base ="abcde12345";
        String repeatedBase = new String(new char[500]).replace("\0",base);
        hexa.findSubstrings(repeatedBase);
        Assert.assertTrue(true);
    }


        // Stretch Goal: Uncomment to execute - ensure your algorithm can run against an input value of maximum length.

     @Test   // 50000 char string
     public void testValidSubstringsVeryLong() {
       String base ="abcde12345";
       String repeatedBase = new String(new char[5000]).replace("\0",base);
       hexa.findSubstrings(repeatedBase);
       Assert.assertTrue(true);
     }

     @Test   // 500000 char string
     public void testValidSubstringsMaxLength() {
       String base ="abcde12345";
       String repeatedBase = new String(new char[50000]).replace("\0",base);
       hexa.findSubstrings(repeatedBase);
       Assert.assertTrue(true);
     }

}
