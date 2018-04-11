package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.*;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

public class DataframeTest {
    private Dataframe subjectFile;
    private List idx;
    private List lbl;
    private List age;
    private List sex;

    /**  TEST CONSTRUCTEUR  **/
    /**  Constructeur CSV
     * @throws java.lang.Exception **/
    @Test (expected = FileNotFoundException.class)
    public void testUnexistingConstructorCSV() throws Exception {
        subjectFile = new Dataframe("myfile.csv");
    }
    
    @Test (expected = ExtensionException.class)
    public void testNoExtensionConstructorCSV() throws Exception {
        subjectFile = new Dataframe("myfile");
    }
    
    @Test (expected = ExtensionException.class)
    public void testWrongExtensionConstructorCSV() throws Exception {
        subjectFile = new Dataframe("myfile.java");
    }
    
    @Test (expected = EmptyCsvException.class)
    public void testEmptyConstructorCSV() throws Exception {
        subjectFile = new Dataframe("data/wrong/empty.csv");
    }
    
    @Test (expected = EmptyCsvException.class)
    public void testOnlyLabelsConstructorCSV() throws Exception {
        subjectFile = new Dataframe("data/wrong/labonly.csv");
    }
    
    @Test (expected = TupleSizeException.class)
    public void testPlusRowConstructorCSV() throws Exception {
        subjectFile = new Dataframe("data/wrong/plusrow.csv");
    }
    
    @Test (expected = TupleSizeException.class)
    public void testMinusRowConstructorCSV() throws Exception {
        subjectFile = new Dataframe("data/wrong/minusrow.csv");
    }
    
    @Test
    public void testSmallConstructorCSV() throws Exception {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Assert.assertTrue("Constructor Passed", true);
    }
    
    @Test
    public void testBigConstructorCSV() throws Exception {
        try {
            subjectFile = new Dataframe("data/big.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Assert.assertTrue("Constructor Passed", true);
    }
    
    /**  Constructeur Brut
     * @throws java.lang.Exception **/
    @Test
    public void testNormalConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=IdxException.class)
    public void testTooManyIndexsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack","ERROR");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=IdxException.class)
    public void testTooFewIndexsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=IdxException.class)
    public void testTooManyElementsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29,30);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=IdxException.class)
    public void testTooFewElementsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=LabelException.class)
    public void testTooManyArraysConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        List error = Arrays.asList(0,1,2);
        
        subjectFile = new Dataframe(idx,lbl,age,sex,error);
    }
    
    @Test (expected=LabelException.class)
    public void testTooFewArraysConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age);
    }
    
    @Test (expected=LabelException.class)
    public void testTooManyLabelsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex","ERROR");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=LabelException.class)
    public void testTooFewLabelsConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    @Test (expected=TypeException.class)
    public void testMultipleTypeConstructor() throws Exception {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex");
        age = Arrays.asList(24,"ERROR",29);
        sex = Arrays.asList('H','F','H');
        
        subjectFile = new Dataframe(idx,lbl,age,sex);
    }
    
    /**  TEST METHODES  **/
    @Test
    public void testFullDisplay() {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Assert.assertTrue("Constructor Passed", true);
        Assert.assertEquals("Index\tage\tsex\t\nJohn\t30\tH\t\nMary\t29\tF\t\nAnna\t18\tF\t\n", subjectFile.toString());
    }
}

