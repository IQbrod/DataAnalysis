package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.*;
import java.io.FileNotFoundException;
import org.junit.Assert;
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

