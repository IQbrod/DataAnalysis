/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;
import java.lang.Number;
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
        Datacol datac = d.getColumn(label);
        if (CheckTyper.checkNumber(datac.lst.get(0))) {
            double moyenne = 0;
            for (int i=0;i<datac.lst.size();i++) {
                Number val = (Number) datac.lst.get(i);
                moyenne += val.doubleValue()
;            }
            return moyenne/datac.lst.size();
        } else {
            throw new TypeException(Number.class, datac.lst.get(0).getClass());
        }
    }
    
    public <T extends Comparable<T>> T getMinCol(Object label) throws Exception {
        Datacol datac = d.getColumn(label);
        T min = null;
        if (CheckTyper.checkComparable(datac.lst.get(0))) {
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
            throw new TypeException(min.getClass(), datac.lst.get(0).getClass());
        }
    }
    
    public <T extends Comparable<T>> T getMaxCol(Object label) throws Exception {
        Datacol datac = d.getColumn(label);
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
