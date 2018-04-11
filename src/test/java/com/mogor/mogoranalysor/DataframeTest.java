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
    public void testFullDisplay() {
        Assert.assertEquals("Index\tage\tsex\t\nJohn\t30\tH\t\nMary\t29\tF\t\nAnna\t18\tF\t\n", subjectFile.toString());
    }
}

