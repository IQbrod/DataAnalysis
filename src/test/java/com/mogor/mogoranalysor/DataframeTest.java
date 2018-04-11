package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

public class DataframeTest {
    private Dataframe subjectFile;

    /**  TEST CONSTRUCTEUR  **/
    /**  Constructeur CSV  **/
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
        subjectFile = new Dataframe("data/empty.csv");
    }
    
    @Test (expected = EmptyCsvException.class)
    public void testOnlyLabelsConstructorCSV() throws Exception {
        subjectFile = new Dataframe("data/labonly.csv");
    }
    
    /**  TEST METHODES  **/
    @Test
    public void testFullDisplay() {
        try {
            subjectFile = new Dataframe("data/people.csv");
        } catch (Exception ex) {
            Assert.fail("No Exception should be thrown for data/people.csv");
        }
        Assert.assertEquals("Index\tage\tsex\t\nJohn\t30\tH\t\nMary\t29\tF\t\nAnna\t18\tF\t\n", subjectFile.toString());
    }
}

