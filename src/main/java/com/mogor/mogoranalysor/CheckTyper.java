package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */
public final class CheckTyper {

    public static void checkType(List lst) throws TypeException {
        Class<?> type = null;
        for (Object lst1 : lst) {
            if (type == null) {
                type = lst1.getClass();
            } else {
                if (lst1.getClass() != type) {
                    throw new TypeException(type, lst1.getClass());
                }
            }
        }
    }

    public static void checkType(HashMap hm) throws TypeException {
        Class<?> type = null;
        for (int i = 0; i < hm.size(); i++) {
            if (type == null) {
                type = hm.get(i).getClass();
            } else {
                if (hm.get(i).getClass() != type) {
                    throw new TypeException(type, hm.get(i).getClass());
                }
            }
        }
    }

    public static boolean checkType(Object expected, Object given) {
        return (expected.getClass() == given.getClass());
    }

    public static boolean checkType(Class<?> expected, Class<?> given) {
        return (expected == given);
    }
    
    public static boolean checkNumber(Object given) {
         return (given instanceof Number);
    }
    
    public static boolean checkComparable(Object given) {
         return (given instanceof Comparable);
    }
}
