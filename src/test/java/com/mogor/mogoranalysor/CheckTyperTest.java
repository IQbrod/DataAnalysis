/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author MrVhek,IQBrod, Skullhack
 */
public class CheckTyperTest {

    @Test
    public void testCheckTypeList() throws Exception {
        try {
            List subject = Arrays.asList("bonjour", "F", "test");
            CheckTyper.checkType(subject);
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for this.");
        }
        try {
            List subject = Arrays.asList("bonjour", 2, "test");
            CheckTyper.checkType(subject);
        } catch (Exception ex) {
            Assert.assertTrue("Not same type in an array should trigger this", true);
        }
    }

    @Test
    public void testCheckTypeHashMap() throws Exception {
        HashMap subject = new HashMap<>();
        try {
            subject.put(0, "salut");
            subject.put(1, "test");
            subject.put(2, "2");
            CheckTyper.checkType(subject);
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for this.");
        }
        try {
            subject.put(0, "salut");
            subject.put(1, 3);
            subject.put(2, "2");
            CheckTyper.checkType(subject);
        } catch (Exception ex) {
            Assert.assertTrue("Not same type in an hashmap should trigger this", true);
        }
    }

    @Test
    public void testCheckTypeObject() {
        int subject1 = 2;
        int subject2 = 8;
        if (CheckTyper.checkType(subject1, subject2)) {
            Assert.assertTrue("Same type should trigger this", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        String subject3 = "test";
        if (CheckTyper.checkType(subject1, subject3)) {
            Assert.fail("You shall not pass.");
        } else {
            Assert.assertTrue("Not same type should trigger this", true);
        }
    }

    @Test
    public void testCheckTypeClass() {
        Class<?> subject1 = int.class;
        Class<?> subject2 = int.class;
        if (CheckTyper.checkType(subject1, subject2)) {
            Assert.assertTrue("Same type should trigger this", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        subject2 = String.class;
        if (CheckTyper.checkType(subject1, subject2)) {
            Assert.fail("You shall not pass.");
        } else {
            Assert.assertTrue("Not same type should trigger this", true);
        }
    }

    @Test
    public void testCheckNumber() {
        int subject1 = 8;
        if (CheckTyper.checkNumber(subject1)) {
            Assert.assertTrue("Int is a Number so it's ok", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        float subject2 = 8;
        if (CheckTyper.checkNumber(subject2)) {
            Assert.assertTrue("Float is also a Number so it's ok", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        String subject3 = "Test";
        if (CheckTyper.checkNumber(subject3)) {
            Assert.fail("You shall not pass.");
        } else {
            Assert.assertTrue("String is not a Number so it's ok", true);
        }
    }

    @Test
    public void testCheckComparable() {
        int subject1 = 8;
        if (CheckTyper.checkComparable(subject1)) {
            Assert.assertTrue("Int is a Comparable so it's ok", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        String subject2 = "Test";
        if (CheckTyper.checkComparable(subject2)) {
            Assert.assertTrue("String is also a Comparable so it's ok", true);
        } else {
            Assert.fail("You shall not pass.");
        }
        Object subject3 = null;
        if (CheckTyper.checkComparable(subject3)) {
            Assert.fail("You shall not pass.");
        } else {
            Assert.assertTrue("Object is not a Comparable so it's ok", true);
        }
    }
}
