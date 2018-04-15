/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author MrVhek,IQBrod, Skullhack
 */
public class DataframeStatisticsTest {
    private DataframeStatistics dfs;
    private Dataframe subject;
    private List idx;
    private List labels;
    private List l1;
    private List l2;
    private List l3;
    private List l4;

    @Test
    public void getMeanColTest() {
        try {
            idx = Arrays.asList(0,1,2,3,4,5);
            labels = Arrays.asList("mean=1","mean=30","wrong","mean=17.9");
            l1 = Arrays.asList(1,1,1,1,1,1);
            l2 = Arrays.asList(15,30,45,15,30,45);
            l3 = Arrays.asList("Hello","Test","Pas","De","Moyenne","Possible");
            l4 = Arrays.asList(19,26.5,8.2,19.0,26.5,8.2);
            subject = new Dataframe(idx,labels,l1,l2,l3,l4);
            dfs = new DataframeStatistics(subject);
            //Test1
            double res1 = dfs.getMeanCol("mean=1");
            Assert.assertEquals("The first column mean is 1", 1, res1);
            double res2 =dfs.getMeanCol("mean=30");
            Assert.assertEquals("The second column mean is 30", 30, res2);
            try {
                double res3 = dfs.getMeanCol("wrong");
                Assert.fail("You should not pass here");
            } catch (Exception e) {
                Assert.assertTrue("You cant get mean of String so it's ok", true);
            }
            double res4 =dfs.getMeanCol("mean=17.9");
            Assert.assertEquals("The last column mean is 17.9", 17.9, res4);
        } catch (Exception e) {
            Assert.fail("No Exception should be thrown for this");
        }

    }
}
