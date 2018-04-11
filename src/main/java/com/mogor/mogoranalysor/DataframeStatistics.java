/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;

/**
 *
 * @author MrVhek,IQBrod, Skullhack
 */
public class DataframeStatistics {
    private Dataframe d;
    
    public DataframeStatistics(Dataframe d) {
        this.d = d;
    }
    
    public double getMeanCol(Object label) throws Exception {
        Object[] o = {label};
        Datacol datac = d.getColumns(o).get(0);
        if (CheckTyper.checkType(datac.lst.getClass(), int.class)
            ||CheckTyper.checkType(datac.lst.getClass(), float.class)
            ||CheckTyper.checkType(datac.lst.getClass(), double.class)) {
            double moyenne = 0;
            for (int i=0;i<datac.lst.size();i++) {
                moyenne += (double) datac.lst.get(i);
            }
            return moyenne/(double) datac.lst.size();
        } else {
            throw new TypeException(double.class, datac.label.getClass());
        }
    }
    
    public <T extends Comparable<T>> T getMinCol(Object label) throws Exception {
        Object[] o = {label};
        Datacol datac = d.getColumns(o).get(0);
        T min = null;
        if (CheckTyper.checkType(datac.lst.getClass(), min.getClass())) {
            for (int i=0;i<datac.lst.size();i++) {
                T t  = (T) datac.lst.get(i);
                if (min == null) {
                    min = t;
                } else if (t.compareTo(min) == -1) {
                    min = t;
                }
            }
            return min;
        } else {
            throw new TypeException(min.getClass(), datac.label.getClass());
        }
    }
    
    public <T extends Comparable<T>> T getMaxCol(Object label) throws Exception {
        Object[] o = {label};
        Datacol datac = d.getColumns(o).get(0);
        T max = null;
        if (CheckTyper.checkType(datac.lst.getClass(), max.getClass())) {
            for (int i=0;i<datac.lst.size();i++) {
                T t  = (T) datac.lst.get(i);
                if (max == null) {
                    max = t;
                } else if (t.compareTo(max) == 1) {
                    max = t;
                }
            }
            return max;
        } else {
            throw new TypeException(max.getClass(), datac.label.getClass());
        }
    }
}
