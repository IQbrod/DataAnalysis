package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        subjectFile.fullDisplay();
        Assert.assertTrue(true);
        Assert.assertEquals("Index\tage\tsex\t\nJohn\t30\tH\t\nMary\t29\tF\t\nAnna\t18\tF\t\n", subjectFile.toString());
    }
    
    @Test
    public void testFirstLinesDisplay() {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        subjectFile.firstLinesDisplay(-5); // lower Value
        subjectFile.firstLinesDisplay(0); // Zero value
        subjectFile.firstLinesDisplay(1); // Min value
        subjectFile.firstLinesDisplay(3); // Max value
        subjectFile.firstLinesDisplay(5); // upper value
        Assert.assertTrue(true);
    }
    
    @Test
    public void testLastLinesDisplay() {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        subjectFile.lastLinesDisplay(-5); // lower Value
        subjectFile.lastLinesDisplay(0); // Zero value
        subjectFile.lastLinesDisplay(1); // Min value
        subjectFile.lastLinesDisplay(3); // Max value
        subjectFile.lastLinesDisplay(5); // upper value
        Assert.assertTrue(true);
    }
    
    @Test
    public void testGetCol() {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex","Str");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        List str = Arrays.asList("aaa","bbb","ccc");
        try {
            subjectFile = new Dataframe(idx,lbl,age,sex,str);
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Datacol c,d;
        try {
            c = subjectFile.getColumn("Age");
            d = new Datacol("Age",age);
            Assert.assertEquals(d.getLabel(), c.getLabel());
            Assert.assertEquals(d.getListObject(), c.getListObject());
            c = subjectFile.getColumn("Sex");
            d = new Datacol("Sex",sex);
            Assert.assertEquals(d.getLabel(), c.getLabel());
            Assert.assertEquals(d.getListObject(), c.getListObject());
            c = subjectFile.getColumn("Str");
            d = new Datacol("Str",str);
            Assert.assertEquals(d.getLabel(), c.getLabel());
            Assert.assertEquals(d.getListObject(), c.getListObject());
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for this dataframe");
        }
    }
    
    @Test (expected=UnknownException.class)
    public void testGetWrongCol() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        subjectFile.getColumn("ERROR");
    }
    
    @Test
    public void testGetCols() {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex","Str");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        List str = Arrays.asList("aaa","bbb","ccc");
        try {
            subjectFile = new Dataframe(idx,lbl,age,sex,str);
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        
        try {
            Object[] o = {"Age","Sex","Str"};
            List<Datacol> m = subjectFile.getColumns(o);
            Datacol c = new Datacol("Age",age);
            Assert.assertEquals(m.get(0).getLabel(), c.getLabel());
            Assert.assertEquals(m.get(0).getListObject(), c.getListObject());
            c = new Datacol("Sex",sex);
            Assert.assertEquals(m.get(1).getLabel(), c.getLabel());
            Assert.assertEquals(m.get(1).getListObject(), c.getListObject());
            c = new Datacol("Str",str);
            Assert.assertEquals(m.get(2).getLabel(), c.getLabel());
            Assert.assertEquals(m.get(2).getListObject(), c.getListObject());
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for this dataframe");
        }
    }
    
    @Test (expected=UnknownException.class)
    public void testGetOnlyWrongCols() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {"ERROR"};
        subjectFile.getColumns(o);
    }
    
    @Test (expected=UnknownException.class)
    public void testGetWrongCols() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {"age","sex","ERROR"};
        subjectFile.getColumns(o);
    }
    
    @Test
    public void testEmptyCols() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {};
        Assert.assertEquals(subjectFile.getColumns(o),new ArrayList<Datacol>());
    }
    
    @Test
    public void testGetLines() {
        idx = Arrays.asList("Paul","Pierre","Jack");
        lbl = Arrays.asList("Age","Sex","Str");
        age = Arrays.asList(24,37,29);
        sex = Arrays.asList('H','F','H');
        List str = Arrays.asList("aaa","bbb","ccc");
        try {
            subjectFile = new Dataframe(idx,lbl,age,sex,str);
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        
        try {
            Object[] o = {"Paul","Pierre","Jack"};
            List<List<Object>> m = subjectFile.getLines(o);
            Assert.assertEquals(m.get(0), Arrays.asList(24,'H',"aaa"));
            Assert.assertEquals(m.get(1), Arrays.asList(37,'F',"bbb"));
            Assert.assertEquals(m.get(2), Arrays.asList(29,'H',"ccc"));            
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for this dataframe");
        }
    }
    
    @Test (expected=UnknownException.class)
    public void testGetOnlyWrongLines() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {"ERROR"};
        subjectFile.getLines(o);
    }
    
    @Test (expected=UnknownException.class)
    public void testGetWrongLines() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {"Mary","Anna","ERROR"};
        subjectFile.getLines(o);
    }
    
    @Test
    public void testEmptyLines() throws UnknownException {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Object[] o = {};
        Assert.assertEquals(subjectFile.getLines(o),new ArrayList<List<Object>>());
    }
}

