/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mogor.mogoranalysor;

import com.mogor.mogoranalysor.exceptions.TypeException;
import java.util.List;

/**
 *
 * @author MrVhek, IQbrod, Skullhack
 */

public class Datacol {
    protected Object label;
    protected List<Object> lst;
    
    public Datacol(Object label, List val) throws TypeException {
        this.label = label;
        this.lst = val;
        CheckTyper.checkType(lst);
    }
    
    public Object getLabel() {
        return this.label;
    }
            
    public List<Object> getListObject() {
        return this.lst;
    }
}