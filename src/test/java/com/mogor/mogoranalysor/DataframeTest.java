package com.mogor.mogoranalysor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

public class DataframeTest {
    private Dataframe subjectFile;

    @Before
    public void setup() throws Exception {
        subjectFile = new Dataframe("data/people.csv");
    }
    
    @Test
    public void testFirstLine() {
        Assert.assertEquals("Index	age	sex	\n" +
                    "John	30	H	\n" +
                    "Mary	29	F	\n" +
                    "Anna	18	F	", subjectFile.toString());
    }
}

