/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author adrien
 */
public final class CheckTyper {
    private CheckTyper() {
    }
    
    public static void checkType(List lst) throws TypeException {
        Class<?> type = null;
        for (int i=0;i<lst.size();i++) {
            if (type == null) {
                type = lst.get(i).getClass();
            } else {
                if (lst.get(i).getClass() != type) {
                    throw new TypeException(type,lst.get(i).getClass());
                }
            }
        }
    }
    
    public static void checkType(HashMap hm) throws TypeException {
        Class<?> type = null;
        for (int i=0;i<hm.size();i++) {
            if (type == null) {
                type = hm.get(i).getClass();
            } else {
                if (hm.get(i).getClass() != type) {
                    throw new TypeException(type,hm.get(i).getClass());
                }
            }
        }
    }
    
    
    public static boolean checkType(Object expected, Object given) {
        if (expected.getClass() == given.getClass()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean checkType(Class<?> expected, Class<?> given) {
        if (expected == given) {
            return true;
        } else {
            return false;
        }
    }
}
