/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Test
    public void getMeanColTest() {
        try {
            idx = Arrays.asList(0, 1, 2, 3, 4, 5);
            labels = Arrays.asList("mean=1", "mean=30", "wrong", "mean=17.9");
            l1 = Arrays.asList(1, 1, 1, 1, 1, 1);
            l2 = Arrays.asList(15, 30, 45, 15, 30, 45);
            l3 = Arrays.asList("Hello", "Test", "Pas", "De", "Moyenne", "Possible");
            l4 = Arrays.asList(19.0, 26.5, 8.2, 19.0, 26.5, 8.2);
            subject = new Dataframe(idx, labels, l1, l2, l3, l4);
            dfs = new DataframeStatistics(subject);
            //Test1
            double res1 = dfs.getMeanCol("mean=1");
            Assert.assertTrue((double) 1 == res1);
            double res2 = dfs.getMeanCol("mean=30");
            Assert.assertTrue((double) 30 == res2);
            try {
                double res3 = dfs.getMeanCol("wrong");
                Assert.fail("You should not pass here");
            } catch (Exception e) {
                Assert.assertTrue("You cant get mean of String so it's ok", true);
            }
            double res4 = dfs.getMeanCol("mean=17.9");
            Assert.assertTrue((double) 17.9 == round(res4, 1));
        } catch (Exception e) {
            Assert.fail("No Exception should be thrown for this");
        }
    }

    @Test
    public void getMinColTest() {
        try {
            idx = Arrays.asList(0, 1, 2, 3, 4, 5);
            labels = Arrays.asList("min=1", "min=15", "wrong", "min=8.2");
            l1 = Arrays.asList(1, 1, 1, 1, 1, 1);
            l2 = Arrays.asList(15, 30, 45, 15, 30, 45);
            l3 = Arrays.asList(new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx));
            l4 = Arrays.asList(19.0, 26.5, 8.2, 19.0, 26.5, 8.2);
            subject = new Dataframe(idx, labels, l1, l2, l3, l4);
            dfs = new DataframeStatistics(subject);
            //Test1
            Comparable<?> res1 = dfs.getMinCol("min=1");
            Assert.assertTrue("1".equals(res1.toString()));
            //Test2
            Comparable<?> res2 = dfs.getMinCol("min=15");
            Assert.assertTrue("15".equals(res2.toString()));
            //Test3
            try {
                Comparable<?> res3 = dfs.getMinCol("wrong");
                Assert.fail("You should not pass here");
            } catch (Exception e) {
                Assert.assertTrue("You cant get min of Object so it's ok", true);
            }
            //Test4
            Comparable<?> res4 = dfs.getMinCol("min=8.2");
            Assert.assertTrue("8.2".equals(res4.toString()));
        } catch (Exception e) {
            Assert.fail("No Exception should be thrown for this");
        }
    }

    @Test
    public void getMaxColTest() {
        try {
            idx = Arrays.asList(0, 1, 2, 3, 4, 5);
            labels = Arrays.asList("max=1", "max=45", "wrong", "max=26.5");
            l1 = Arrays.asList(1, 1, 1, 1, 1, 1);
            l2 = Arrays.asList(15, 30, 45, 15, 30, 45);
            l3 = Arrays.asList(new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx), new Datacol(labels, idx));
            l4 = Arrays.asList(19.0, 26.5, 8.2, 19.0, 26.5, 8.2);
            subject = new Dataframe(idx, labels, l1, l2, l3, l4);
            dfs = new DataframeStatistics(subject);
            //Test1
            Comparable<?> res1 = dfs.getMaxCol("max=1");
            Assert.assertTrue("1".equals(res1.toString()));
            //Test2
            Comparable<?> res2 = dfs.getMaxCol("max=45");
            Assert.assertTrue("45".equals(res2.toString()));
            //Test3
            try {
                Comparable<?> res3 = dfs.getMaxCol("wrong");
                Assert.fail("You should not pass here");
            } catch (Exception e) {
                Assert.assertTrue("You cant get max of Object so it's ok", true);
            }
            //Test4
            Comparable<?> res4 = dfs.getMaxCol("max=26.5");
            Assert.assertTrue("26.5".equals(res4.toString()));
        } catch (Exception e) {
            Assert.fail("No Exception should be thrown for this");
        }
    }
}
